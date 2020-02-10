package com.ufabc.adm.user.dto;

import com.ufabc.adm.user.model.User;

public class UserDtoForList {
  
  private Integer id;
  
  private String name;
  
  private String ra;
  
  public UserDtoForList() {
  }
  
  public UserDtoForList(Integer id, String name, String ra) {
    super();
    this.id = id;
    this.name = name;
    this.ra = ra;
  }
  
  public UserDtoForList(User user) {
    super();
    this.id = user.getId();
    this.name = user.getName();
    this.ra = user.getRa();
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getRa() {
    return ra;
  }
  
  public void setRa(String ra) {
    this.ra = ra;
  }
}
