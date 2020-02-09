package com.ufabc.adm.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufabc.adm.course.model.Course;
import com.ufabc.adm.course.repository.CourseRepository;

@Service
public class CourseService {
  
  @Autowired
  private CourseRepository courseRepository;
  
  public List<Course> getAll() {
    return courseRepository.findAll();
  }
  
}
