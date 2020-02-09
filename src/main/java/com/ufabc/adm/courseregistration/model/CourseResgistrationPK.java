package com.ufabc.adm.courseregistration.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ufabc.adm.course.model.Course;
import com.ufabc.adm.user.model.User;

@Embeddable
public class CourseResgistrationPK implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @ManyToOne
  @JoinColumn(name = "student_id")
  private User user;
  
  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  public Course getCourse() {
    return course;
  }
  
  public void setCourse(Course course) {
    this.course = course;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((course == null) ? 0 : course.hashCode());
    result = prime * result + ((user == null) ? 0 : user.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CourseResgistrationPK other = (CourseResgistrationPK) obj;
    if (course == null) {
      if (other.course != null)
        return false;
    } else if (!course.equals(other.course))
      return false;
    if (user == null) {
      if (other.user != null)
        return false;
    } else if (!user.equals(other.user))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "CourseResgistrationPK [user=" + user + ", course=" + course + "]";
  }
  
}
