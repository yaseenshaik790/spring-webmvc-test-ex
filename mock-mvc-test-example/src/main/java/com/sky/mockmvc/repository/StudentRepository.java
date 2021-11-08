package com.sky.mockmvc.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.mockmvc.controller.api.StudentResponse;
import com.sky.mockmvc.dto.StudentRequest;
import com.sky.mockmvc.model.Student;
import com.sky.mockmvc.model.StudentDao;

@Repository
public class StudentRepository {

	@Autowired
	private StudentDao dao;

	public String saveStudent(StudentRequest request) {

		Student student = new Student();
		BeanUtils.copyProperties(request, student);
		dao.save(student);

		return "Student Saved Successfully";
	}

	public StudentResponse getStudent(Long studentId) {

		Student student = dao.findByStudentId(studentId);

		return new StudentResponse(student.getStudentId(), student.getStudentName(), student.getAge());
	}

}
