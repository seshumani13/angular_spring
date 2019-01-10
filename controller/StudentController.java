package com.hcltss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcltss.dao.StudentDAO;
import com.hcltss.dao.StudentDAOImpl;
import com.hcltss.pojo.Student;
@Controller
public class StudentController {

	@Autowired
	StudentDAOImpl dao;

	 @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
		      return new ModelAndView("student", "command", new Student());
	   }
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	      public String addStudent(@ModelAttribute("Angular_SpringMVC")Student student, 
	   
	   ModelMap model) {
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());
	      return "result";
	   }
	   @RequestMapping(value="/create")  
	    public ModelAndView create(@ModelAttribute("student") Student student){ 
		   System.out.println("inside create method");
	       dao.create(student);  
	       return new ModelAndView("redirect:/");
	     //  return new ModelAndView("redirect:/viewStudent");
	     } 
	   @RequestMapping(value="/viewStudent")  
	     public ModelAndView viewstudent(){  
		   System.out.println("inside view student");
	         List<Student> list=dao.listStudents();
	         System.out.println("list"+list);
	         return new ModelAndView("viewStudentList","list",list);  
	      } 

	   @RequestMapping(value="/editsave")  
	      public ModelAndView editsave(@ModelAttribute("student") Student student){  
	         dao.update(student);  
	          return new ModelAndView("redirect:/");  
	      }  
	   @RequestMapping(value="/deletestudent/{id}")  
	      public ModelAndView delete(@ModelAttribute("student") Student student){ 
		   	  System.out.println("inside delete method in controller");
	          dao.delete(student.getId());  
	          return new ModelAndView("redirect:/");  
	     }  
	   @RequestMapping(value="/editstudent/{id}")  
	     public ModelAndView edit(@PathVariable int id){  
	          Student student=dao.getStudent(id);  
	         return new ModelAndView("editStudent","command",student);  
	       }



}
