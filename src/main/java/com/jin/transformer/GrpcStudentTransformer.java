package com.jin.transformer;

import org.springframework.stereotype.Component;

import com.jin.domain.Student;
import com.jin.grpc.Student.GrpcStudent;
import com.jin.grpc.Student.GrpcStudent.Builder;

@Component
public class GrpcStudentTransformer {

	public Student transform(GrpcStudent grpcStudent) {
		
		Student student = new Student();
		if (grpcStudent.getId() != 0) {
			student.setId(grpcStudent.getId());
		}
		student.setFirstName(grpcStudent.getFirstName());
		student.setLastName(grpcStudent.getLastName());
		student.setAge(grpcStudent.getAge());
		
		return student;
	}
	
	public GrpcStudent transform(Student student) {
		Builder builder = GrpcStudent.newBuilder();
		
		if (student.getId() != null) {
			builder.setId(student.getId().longValue());
		}

		GrpcStudent grpcStudent = builder.setFirstName(student.getFirstName()).setLastName(student.getLastName()).setAge(student.getAge()).build();
		
		return grpcStudent;

	}

}
