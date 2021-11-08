package com.sky.mockmvc.controller.api;

public class StudentResponse {

	private Long studentId;
	private String studentName;
	private Integer age;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

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

	public StudentResponse(Long studentId, String studentName, Integer age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
	}

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
