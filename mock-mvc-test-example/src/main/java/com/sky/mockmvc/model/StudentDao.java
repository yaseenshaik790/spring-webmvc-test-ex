package com.sky.mockmvc.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {

	Student findByStudentId(Long studentId);

}
