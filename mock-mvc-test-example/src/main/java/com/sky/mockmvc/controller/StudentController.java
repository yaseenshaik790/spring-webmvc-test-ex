package com.sky.mockmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sky.mockmvc.controller.api.StudentResponse;
import com.sky.mockmvc.dto.StudentRequest;
import com.sky.mockmvc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody(required = true) StudentRequest request) {

		String response = service.saveStudent(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentResponse> getStudent(@PathVariable Long studentId) {
		StudentResponse response = service.getStudent(studentId);

		return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
	}

}
