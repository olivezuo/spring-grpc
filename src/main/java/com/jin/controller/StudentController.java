package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jin.domain.Student;
import com.jin.grpc.service.StudentGrpcClientService;

@RestController
public class StudentController {

	@Autowired
	StudentGrpcClientService studentGrpcClientService;
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public Student addStudent(@RequestBody Student student) {
		
		return studentGrpcClientService.addStudent(student);
	}
	
}
