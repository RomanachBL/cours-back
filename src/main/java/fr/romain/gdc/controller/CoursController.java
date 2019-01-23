package fr.romain.gdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.romain.gdc.model.Cours;
import fr.romain.gdc.service.CoursService;

@Controller
public class CoursController {

	//Vers les fonctions de CoursServices
private CoursService CoursService;
	
	@Autowired(required=true)
	@Qualifier(value="CoursService")
	public void setCoursService(CoursService ps){
		this.CoursService = ps;
	}
	
	@RequestMapping(value = "/cours", method = RequestMethod.GET)
	public String listCours(Model model) {
		model.addAttribute("cours", new Cours());
		model.addAttribute("listCours", this.CoursService.listCours());
		return "cours";
	}
	
	//For add and update person both
	@RequestMapping(value= "/cours/add", method = RequestMethod.POST)
	public String addCours(@ModelAttribute("cours") Cours p){
		
		if(p.getIdc() == 0){
			this.CoursService.addCours(p);
		}else{
			this.CoursService.updateCours(p);
		}
		
		return "redirect:/cours";
		
	}
	
	@RequestMapping("/removeCours/{idc}")
    public String removeCours(@PathVariable("idc") int idc){
		
        this.CoursService.removeCours(idc);
        return "redirect:/cours";
    }
 
    @RequestMapping("/editCours/{idc}")
    public String editCours(@PathVariable("idc") int idc, Model model){
        model.addAttribute("cours", this.CoursService.getCoursById(idc));
        model.addAttribute("listCours", this.CoursService.listCours());
        return "cours";
    }

    
    @RequestMapping(value = "/sessDet/{idsess}")
	public String getOneSession(@PathVariable("idsess") int idsess, Model model) {
		model.addAttribute("sessDet", this.CoursService.getSessionById(idsess));
		return "sessDet";
	}
    
    
}
