package com.sky.mockmvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.mockmvc.controller.api.StudentResponse;
import com.sky.mockmvc.model.Student;
import com.sky.mockmvc.service.StudentService;

@WebMvcTest
public class StudentControllerTest {

	@MockBean
	private StudentService service;

	@Autowired
	private MockMvc mockMvc;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPostExample() throws Exception {
		Student student = new Student();
		student.setStudentId(1l);
		student.setStudentName("Arun");
		student.setAge(22);
		Mockito.when(service.saveStudent(ArgumentMatchers.any())).thenReturn("Student Saved Successfully");
		String json = mapper.writeValueAsString(student);
		MvcResult mvcResult = mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		assertEquals(result, "Student Saved Successfully");
	}

	@Test
	public void testGetStudent() throws Exception {

		StudentResponse student = new StudentResponse();
		student.setStudentId(1l);
		student.setStudentName("Arun");
		student.setAge(22);

		Mockito.when(service.getStudent(anyLong())).thenReturn(student);
		mockMvc.perform(get("/{studentId}", 1)).andExpect(status().isOk())
				.andExpect(jsonPath("$.age", Matchers.equalTo(22)))
				.andExpect(jsonPath("$.studentName", Matchers.equalTo("Arun")))
				.andExpect(jsonPath("$.studentId", Matchers.equalTo(1)));
	}

}
