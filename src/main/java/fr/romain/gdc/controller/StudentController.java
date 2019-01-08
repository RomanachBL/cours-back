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

import fr.romain.gdc.model.Student;
import fr.romain.gdc.service.StudentService;

@Controller
public class StudentController {
		
private StudentService studentService;
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ps){
		this.studentService = ps;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String listStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "student";
	}
	
	//For add and update person both
	@RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student p){
		
		if(p.getIds() == 0){
			//new person, add it
			this.studentService.addStudent(p);
		}else{
			//existing person, call update
			this.studentService.updateStudent(p);
		}
		
		return "redirect:/student";
		
	}
	
	@RequestMapping("/removeStu/{ids}")
    public String removeStudent(@PathVariable("ids") int ids){
		
        this.studentService.removeStudent(ids);
        return "redirect:/student";
    }
 
    @RequestMapping("/editStu/{ids}")
    public String editStudent(@PathVariable("ids") int ids, Model model){
        model.addAttribute("student", this.studentService.getStudentById(ids));
        model.addAttribute("listStudent", this.studentService.listStudent());
        return "student";
    }
	
    @RequestMapping(value = "/entStu")
	public String getOneStudent(@RequestParam(value="ids") int ids, Model model) {
		model.addAttribute("entStudent", this.studentService.getStudentById(ids));
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "entStudent";
	}
    
}
