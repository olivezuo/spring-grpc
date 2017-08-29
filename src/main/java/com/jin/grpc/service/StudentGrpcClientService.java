package com.jin.grpc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.domain.Student;
import com.jin.grpc.Student.AddStudentRequest;
import com.jin.grpc.Student.AddStudentResponse;
import com.jin.grpc.Student.GrpcStudent;
import com.jin.grpc.StudentGrpcServiceGrpc;
import com.jin.grpc.StudentGrpcServiceGrpc.StudentGrpcServiceBlockingStub;
import com.jin.transformer.GrpcStudentTransformer;

import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

@Service
public class StudentGrpcClientService {

	private static final Logger logger = LoggerFactory.getLogger(StudentGrpcClientService.class);
	
	@Autowired
	GrpcStudentTransformer grpcStudentTransformer;

	@GrpcClient("local-grpc-server")
    private Channel serverChannel;
	
	public Student addStudent(Student student) {
		StudentGrpcServiceBlockingStub stub = StudentGrpcServiceGrpc.newBlockingStub(serverChannel);
		
		GrpcStudent grpcStudent = grpcStudentTransformer.transform(student);
		AddStudentRequest request = AddStudentRequest.newBuilder().setStudent(grpcStudent).build();
		
		AddStudentResponse response = stub.addStudent(request);
		student = grpcStudentTransformer.transform(response.getStudent());
		
		return student;
		
	}
}
