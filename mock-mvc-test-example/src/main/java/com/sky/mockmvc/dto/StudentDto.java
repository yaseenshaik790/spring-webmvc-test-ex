package com.sky.mockmvc.dto;

public class StudentDto {

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

	public StudentDto(Long studentId, String studentName, Integer age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
