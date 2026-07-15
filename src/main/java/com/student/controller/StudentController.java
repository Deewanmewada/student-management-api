package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentEntity;
import com.student.request.StudentRequest;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")

public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody StudentRequest request) {
		
		return  service.saveStudent(request);
		
		
	}
	
	
	//get all students
	@GetMapping("/findstudent")
	public List<StudentEntity> getAllStudents() {
		
		List<StudentEntity> students = service.getAllStudents();
		
		return  students;
	}
	
	//get student by id
	
	@GetMapping("/findbyid/{id}")
	public StudentEntity findById(@PathVariable("id") int id) {
		
	    System.out.println("Controller received id = " + id);

		return service.getStudentById(id);
		
	}
	
	//update 
	@PutMapping("/updatestudent/{id}")
	public String update(@PathVariable("id") int id, @RequestBody StudentRequest request) {
		
		return service.updateStudent(request, id);
	}
	
	
	//delete 
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
		
		return service.deleteStudent(id);
	}

	
	
}
