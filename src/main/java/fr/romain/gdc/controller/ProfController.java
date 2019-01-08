package fr.romain.gdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.romain.gdc.model.Prof;
import fr.romain.gdc.service.ProfService;

@Controller
public class ProfController {
		
private ProfService ProfService;
	
	@Autowired(required=true)
	@Qualifier(value="ProfService")
	public void setProfService(ProfService ps){
		this.ProfService = ps;
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
			//new person, add it
			this.ProfService.addProf(p);
		}else{
			//existing person, call update
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
		model.addAttribute("entProf", this.ProfService.getProfById(idp));
		return "entProf";
	}
	
}
