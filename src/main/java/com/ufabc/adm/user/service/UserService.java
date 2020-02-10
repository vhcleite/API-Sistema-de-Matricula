package com.ufabc.adm.user.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufabc.adm.courseregistration.service.CourseRegistrationService;
import com.ufabc.adm.user.model.User;
import com.ufabc.adm.user.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private CourseRegistrationService crService;
  
  public Collection<User> getAll() {
    return userRepository.findAll();
  }
  
  public User getById(Integer id) {
    return userRepository.findById(id).orElseThrow();
  }
  
  public User create(User user) {
    User newUser = userRepository.save(user);
    
    newUser.getRegistrations().stream().forEach(r -> {
      r.setUser(newUser);
      crService.create(r);
    });
    
    return newUser;
  }
  
  public User update(User newUser) {
    Optional<User> useropt = userRepository.findById(newUser.getId());
    User user = useropt.orElseThrow();
    user.setName(newUser.getName());
    user.setRa(newUser.getRa());
    return userRepository.save(user);
  }
  
  public void delete(Integer id) {
    userRepository.deleteById(id);
  }
  
}
