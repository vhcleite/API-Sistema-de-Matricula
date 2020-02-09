package com.ufabc.adm.user.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufabc.adm.user.model.User;
import com.ufabc.adm.user.service.UserService;

@RestController
@RequestMapping("ufabc/adm/users")
public class UserController {
  
  @Autowired
  UserService userService;
  
  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok().body(userService.getAll().stream().collect(Collectors.toList()));
    
  }
  
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {
    user.setId(null);
    User userCreated = userService.create(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId())
        .toUri();
    return ResponseEntity.created(uri).build();
  }
  
  @PutMapping(value = "/{id}")
  public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
    user.setId(id);
    return ResponseEntity.ok().body(userService.update(user));
  }
}
