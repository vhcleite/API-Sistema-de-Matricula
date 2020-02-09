package com.ufabc.adm.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufabc.adm.course.model.Course;
import com.ufabc.adm.course.service.CourseService;

@RestController
@RequestMapping("ufabc/adm/courses")
public class CourseController {
  
  @Autowired
  CourseService courseService;
  
  @GetMapping
  public ResponseEntity<List<Course>> findAll() {
    return ResponseEntity.ok().body(courseService.getAll());
  }
  
}
