package com.ufabc.adm.courseregistration.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufabc.adm._enums.CourseRegistrationStatus;
import com.ufabc.adm.course.model.Course;
import com.ufabc.adm.user.model.User;

@Entity
public class CourseRegistration implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @EmbeddedId
  @JsonIgnore
  private CourseResgistrationPK id = new CourseResgistrationPK();
  
  private LocalDateTime registrationDate;
  
  private Integer status;
  
  public CourseRegistration() {
  }
  
  public CourseRegistration(User user, Course course) {
    super();
    this.id.setUser(user);
    this.id.setCourse(course);
    this.registrationDate = LocalDateTime.now();
    this.status = CourseRegistrationStatus.ACTIVE.getId();
  }
  
  public CourseResgistrationPK getId() {
    return id;
  }
  
  public void setId(CourseResgistrationPK id) {
    this.id = id;
  }
  
  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }
  
  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }
  
  public CourseRegistrationStatus getStatus() {
    return CourseRegistrationStatus.fromId(status);
  }
  
  public void setStatus(CourseRegistrationStatus status) {
    this.status = status.getId();
  }
  
  public Course getCourse() {
    return id.getCourse();
  }
  
  public void setUser(User user) {
    this.id.setUser(user);
  }
  
  public void setCourse(Course course) {
    this.id.setCourse(course);
  }
}
