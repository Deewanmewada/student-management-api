package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;
import com.student.repository.StudentRepository;
import com.student.request.StudentRequest;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	//save student
	public String saveStudent(StudentRequest request) {
		
		StudentEntity entity = new StudentEntity();
		
		entity.setName(request.getName());
		entity.setAge(request.getAge());
		entity.setEmail(request.getEmail());
		entity.setCourse(request.getCourse());
		
		StudentEntity response = repository.save(entity);
		
		return "Student Saved Successfully. Student Id : " + response.getId();
	}
	
	
	//view all student
	
	public List<StudentEntity> getAllStudents(){
		
		return repository.findAll();
	}
	
	//get Student by id
	
	public StudentEntity getStudentById(int id) {
		
		Optional<StudentEntity> optinal = repository.findById(id);
		
		System.out.println(optinal);
		
		if(optinal.isPresent()) {
			StudentEntity entity = optinal.get();
			return entity;
		}
		
		return null;
	}
	
	// Update 
	
	public String updateStudent(StudentRequest request, int id) {
		
		Optional<StudentEntity> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			
			entity.setName(request.getName());
			entity.setAge(request.getAge());
			entity.setEmail(request.getEmail());
			entity.setCourse(request.getCourse());
			
			repository.save(entity);
			
			return "Student Updated Successfully";
		}
		
		return "Student Not Found";
		
		
	}
	
	//Delete 
	public String deleteStudent(int id) {
		
		Optional<StudentEntity> optional =  repository.findById(id);
		
		if(optional.isPresent()) {
			
			StudentEntity entity = optional.get();
			repository.delete(entity);
			
			return "deleted successfully"+ id ;
		}
		return "NOT found" ;
		
		
		
	}
}
