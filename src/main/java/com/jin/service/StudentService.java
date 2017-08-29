package com.jin.service;

import org.springframework.stereotype.Service;

import com.jin.domain.Student;

@Service
public class StudentService {

	public Student add(Student student) {
		student.setId(10L);
		return student;
	}	
	
	public Student get() {
		Student student = new Student();
		student.setId(2L);
		
		return student;
	}
}
