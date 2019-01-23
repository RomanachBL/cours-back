package fr.romain.gdc.controller;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.romain.gdc.model.Cours;
import fr.romain.gdc.model.Prof;
import fr.romain.gdc.model.SessionCours;
import fr.romain.gdc.service.ProfService;
import fr.romain.gdc.service.CoursService;

@Controller
public class ProfController {
		
//Vers les fonctions de ProfServices
private ProfService ProfService;

//Vers les fonctions de CoursServices
private CoursService CoursService;
	
	@Autowired(required=true)
	@Qualifier(value="ProfService")
	public void setProfService(ProfService ps){
		this.ProfService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="CoursService")
	public void setCoursService(CoursService pc){
		this.CoursService = pc;
	}
	
	@RequestMapping(value = "/prof", method = RequestMethod.GET)
	public String listProf(Model model) {
		model.addAttribute("prof", new Prof());
		model.addAttribute("listProf", this.ProfService.listProf());
		return "prof";
	}
	
	//For add and update person both
	@RequestMapping(value= "/prof/add", method = RequestMethod.POST)
	public String addProf(@ModelAttribute("prof") Prof p){
		
		if(p.getIdp() == 0){
			this.ProfService.addProf(p);
		}else{
			this.ProfService.updateProf(p);
		}
		
		return "redirect:/prof";
		
	}
	
	@RequestMapping("/removeProf/{idp}")
    public String removeProf(@PathVariable("idp") int idp){
		
        this.ProfService.removeProf(idp);
        return "redirect:/prof";
    }
 
    @RequestMapping("/editProf/{idp}")
    public String editProf(@PathVariable("idp") int idp, Model model){
        model.addAttribute("prof", this.ProfService.getProfById(idp));
        model.addAttribute("listProf", this.ProfService.listProf());
        return "prof";
    }
    
    @RequestMapping(value = "/entProf")
	public String getOneProf(@RequestParam(value="idp") int idp, Model model) {
    	model.addAttribute("sess", new SessionCours());
		model.addAttribute("entProf", this.ProfService.getProfById(idp));
		model.addAttribute("listCours", this.CoursService.listCours());
		return "entProf";
	}
    
    // ========================== Ajouter une spécialité (un cours que le prof peut enseigné) ===================================
    
    @RequestMapping("/speAdd/{idp}")
    public String addSpe(@RequestParam("idcours") Integer idcours, @PathVariable("idp") int idp) {
    	
    	Cours cours = this.CoursService.getCoursById(idcours);
    	Prof prof = this.ProfService.getProfById(idp);
    	
    	Set<Cours> setCours = new HashSet<Cours>();
    	setCours.add(cours);
    	
    	prof.getSpeCours().addAll(setCours);
    	
    	this.ProfService.updateProf(prof);
    	
    	return "redirect:/entProf/?idp={idp}";
    }
    
    
    // ========================== Gestion sessions ===================================
    
    @RequestMapping("/sessadd/{idp}")
	public String addSess(
			@RequestParam("idprof") Integer idprof, 
			@RequestParam("idcours") Integer idcours, 
			@RequestParam("datedeb") Date datedeb, 
			@RequestParam("semaines") Integer semaines){

    	Prof prof = this.ProfService.getProfById(idprof);
    	Cours cours = this.CoursService.getCoursById(idcours);
    	
    	SessionCours sc = new SessionCours(cours, prof, datedeb, semaines);
    	Set<SessionCours> setSess = new HashSet<SessionCours>();
    	setSess.add(sc);
    	
    	prof.getSessions().addAll(setSess);
    	
    	this.ProfService.addSession(sc);  
    	this.ProfService.updateProf(prof);

		return "redirect:/entProf/?idp={idp}";
		
	}

    
    @RequestMapping("/removeSess/{idp}/{idsess}")
    public String removeSess(@PathVariable("idsess") int idsess){
		
        this.ProfService.removeSession(idsess);
        return "redirect:/entProf/?idp={idp}";
    }
    
}
