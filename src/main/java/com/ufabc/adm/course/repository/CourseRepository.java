package com.ufabc.adm.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufabc.adm.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
  
}
