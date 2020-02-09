package com.ufabc.adm.courseregistration.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufabc.adm._enums.CourseRegistrationStatus;
import com.ufabc.adm.courseregistration.model.CourseRegistration;
import com.ufabc.adm.courseregistration.repository.CourseRegistrationRepository;

@Service
public class CourseRegistrationService {
  
  @Autowired
  private CourseRegistrationRepository crRepository;
  
  public CourseRegistration create(CourseRegistration courseResgistration) {
    courseResgistration.setStatus(CourseRegistrationStatus.ACTIVE);
    courseResgistration.setRegistrationDate(LocalDateTime.now());
    return crRepository.save(courseResgistration);
  }
}
