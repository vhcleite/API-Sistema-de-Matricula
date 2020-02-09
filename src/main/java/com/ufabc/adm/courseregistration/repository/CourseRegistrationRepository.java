package com.ufabc.adm.courseregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufabc.adm.courseregistration.model.CourseRegistration;
import com.ufabc.adm.courseregistration.model.CourseResgistrationPK;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, CourseResgistrationPK> {
  
}
