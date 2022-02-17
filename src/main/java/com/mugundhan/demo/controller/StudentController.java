package com.mugundhan.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mugundhan.demo.dao.StudentRepo;
import com.mugundhan.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/AddStudent")
	public Student addStudent(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
	@RequestMapping("/GetStudent")
	public ModelAndView getStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showStudent.jsp");
		Student student = repo.findById(id).orElse(new Student());
		mv.addObject(student);
		return mv;
	}
	@PutMapping("/update")
	public Student updateStud(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}
	@RequestMapping("/UpdateStudent")
	public ModelAndView updateStudent(@RequestParam int id,@RequestParam String name, @RequestParam String phone_number) {
		
		ModelAndView mv = new ModelAndView("showStudent.jsp");
		Student student = repo.findById(id).orElse(new Student());
		if(!name.equals("")) {
			student.setName(name);
		}
		if(!phone_number.equals("")) {
			student.setPhone_number(phone_number);
		}
		repo.save(student);
		mv.addObject(student);
		return mv;
	}
	@RequestMapping("/DeleteStudent")
	public String deleteStudent(@RequestParam int id) {
	    if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    }
	    return "home.jsp";
	}
	@RequestMapping("/GetStudentByName")
	public ModelAndView getStudentByName(@RequestParam String name) {
		ModelAndView mv = new ModelAndView("showAllStudent.jsp");
		List<Student> studentList = repo.findByName(name);
		System.out.print(studentList.toString());
		mv.addObject("studentList",studentList);
		return mv;
	}
	@RequestMapping("/GetAllStudents")
	public ModelAndView getAllStudents() {
		ModelAndView mv = new ModelAndView("showAllStudent.jsp");
		List<Student> studentList = (List<Student>) repo.findByAllSorted();
		System.out.print(studentList.toString());
		mv.addObject("studentList",studentList);
		return mv;
	}
	@RequestMapping(path = "/students",produces = {"application/xml"})
	@ResponseBody
	public List<Student> getStudents() {
		return repo.findAll();
	}
	@RequestMapping("/student/{id}")
	@ResponseBody
	public Optional<Student> getStudentById(@PathVariable("id") int id) {
		return repo.findById(id);
	}
}
