package com.ufabc.adm.user.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.ufabc.adm.courseregistration.model.CourseRegistration;

@Entity
public class User implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @NotEmpty
  private String name;
  
  @NotEmpty
  private String ra;
  
  @OneToMany(mappedBy = "id.user")
  private Set<CourseRegistration> registrations = new HashSet<CourseRegistration>();
  
  User() {
    
  }
  
  public User(Integer id, String name, String ra) {
    super();
    this.id = id;
    this.name = name;
    this.ra = ra;
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
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", ra=" + ra + "]";
  }
  
  public Set<CourseRegistration> getRegistrations() {
    return registrations;
  }
  
  public void setRegistrations(Set<CourseRegistration> registrations) {
    this.registrations = registrations;
  }
}
