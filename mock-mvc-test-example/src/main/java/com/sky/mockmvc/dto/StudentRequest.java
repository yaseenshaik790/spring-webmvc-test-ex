package com.sky.mockmvc.dto;

public class StudentRequest {

	private String studentName;
	private Integer age;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public StudentRequest(String studentName, Integer age) {
		super();

		this.studentName = studentName;
		this.age = age;
	}

}
