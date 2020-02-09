package com.ufabc.adm._enums;

import java.util.Arrays;

public enum CourseRegistrationStatus {
  BLOCKED(1), //
  ACTIVE(2), //
  CONCLUDED(3);
  
  private Integer id;
  
  private CourseRegistrationStatus(Integer id) {
    this.id = id;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public static CourseRegistrationStatus fromId(Integer id) {
    for (CourseRegistrationStatus status : Arrays.asList(CourseRegistrationStatus.values())) {
      if (status.getId() == id)
        return status;
    }
    return null;
  }
  
}
