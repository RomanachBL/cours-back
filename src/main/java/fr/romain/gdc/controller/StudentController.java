package fr.romain.gdc.controller;

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

import fr.romain.gdc.model.Student;
import fr.romain.gdc.model.SessionCours;
import fr.romain.gdc.service.StudentService;

@Controller
public class StudentController {
		
//Vers les fonctions de studentServices
private StudentService studentService;
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ps){
		this.studentService = ps;
	}
	
	//Permet de lister les étudiant sur la page "/student" en récupérant la liste des étudiants avec listStudent()
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String listStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "student";
	}
	
	//Fonction qui ajoute et modifie aussi 
	@RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student p){
		
		//Ajoute (add) ou modifie (update) selon l'id. 
		if(p.getIds() == 0){
			this.studentService.addStudent(p);
		}else{
			this.studentService.updateStudent(p);
		}
		
		return "redirect:/student";
	}
	
	//Utilise la variable "ids" (id de l'étudiant) que l'on passe en get et que l'on récupère grâce à @PathVariable (et on le remove selon cet id)
	@RequestMapping("/removeStu/{ids}")
    public String removeStudent(@PathVariable("ids") int ids){
		
        this.studentService.removeStudent(ids);
        return "redirect:/student";
    }
 
	// Même principe pour récupérer l'id. 
    @RequestMapping("/editStu/{ids}")
    public String editStudent(@PathVariable("ids") int ids, Model model){
        model.addAttribute("student", this.studentService.getStudentById(ids));
        model.addAttribute("listStudent", this.studentService.listStudent());
        return "student";
    }
	
    // Qui permet d'accéder à l'ENT de l'étudiant, en récupérant l'id de l'étudiant, la liste de tous les étudiants et la liste des sessions de cours (qui nous serviront dans le JSP). 
    @RequestMapping(value = "/entStu")
	public String getOneStudent(@RequestParam(value="ids") int ids, Model model) {
    	model.addAttribute("sess", new SessionCours());
		model.addAttribute("entStudent", this.studentService.getStudentById(ids));
		model.addAttribute("listStudent", this.studentService.listStudent());
		//Liste de toutes les sessions pour pouvoir s'inscrire
		model.addAttribute("listSessions", this.studentService.listSessions());
		return "entStudent";
	}
    
    // Pour qu'un étudiant s'inscrive à une session. On veut ajouter dans la table @ManyToMany (Inscription). 
    @RequestMapping("/inscr/{idsess}/{ids}")
    public String formInscription(@PathVariable("idsess") int idsess, @PathVariable("ids") int ids){
    	
    	SessionCours sess = this.studentService.getSessionById(idsess);
    	Student stu = this.studentService.getStudentById(ids);

    	
    	Set<SessionCours> setSess = new HashSet<SessionCours>();
    	setSess.add(sess);
    	
    	stu.getInscSessions().addAll(setSess);
    	
    	this.studentService.updateStudent(stu);
    	
        return "redirect:/entStu/?ids={ids}";
    }
   

}
