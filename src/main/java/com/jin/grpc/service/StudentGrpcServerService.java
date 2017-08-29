package com.jin.grpc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jin.domain.Student;
import com.jin.grpc.Student.AddStudentRequest;
import com.jin.grpc.Student.AddStudentResponse;
import com.jin.grpc.Student.GrpcStudent;
import com.jin.grpc.StudentGrpcServiceGrpc;
import com.jin.grpc.StudentGrpcServiceGrpc.StudentGrpcServiceImplBase;
import com.jin.service.StudentService;
import com.jin.transformer.GrpcStudentTransformer;

import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(StudentGrpcServiceGrpc.class)
public class StudentGrpcServerService extends StudentGrpcServiceImplBase {
	private static final Logger logger = LoggerFactory.getLogger(StudentGrpcServerService.class);
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	GrpcStudentTransformer grpcStudentTransformer;
	
	
	@Override
	public void addStudent(AddStudentRequest request, StreamObserver<AddStudentResponse> responseObserver) {
		
		AddStudentResponse response = null;
		GrpcStudent grpcStudent = request.getStudent();
		
		Student student = grpcStudentTransformer.transform(grpcStudent);
		student = studentService.add(student);
		
		grpcStudent = grpcStudentTransformer.transform(student);
		response = AddStudentResponse.newBuilder().setResult(true).setStudent(grpcStudent).build();
		
		responseObserver.onNext(response);
        responseObserver.onCompleted();
	}
}
