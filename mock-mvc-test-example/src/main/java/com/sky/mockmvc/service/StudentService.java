package com.sky.mockmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.mockmvc.controller.api.StudentResponse;
import com.sky.mockmvc.dto.StudentRequest;
import com.sky.mockmvc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public String saveStudent(StudentRequest request) {

		return repository.saveStudent(request);
	}

	public StudentResponse getStudent(Long studentId) {
		// TODO Auto-generated method stub
		return repository.getStudent(studentId);
	}

}
