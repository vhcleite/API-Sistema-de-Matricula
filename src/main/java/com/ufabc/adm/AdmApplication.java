package com.ufabc.adm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ufabc.adm.course.model.Course;
import com.ufabc.adm.course.repository.CourseRepository;
import com.ufabc.adm.courseregistration.model.CourseRegistration;
import com.ufabc.adm.courseregistration.repository.CourseRegistrationRepository;
import com.ufabc.adm.user.model.User;
import com.ufabc.adm.user.repository.UserRepository;

@SpringBootApplication
public class AdmApplication implements CommandLineRunner {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private CourseRepository courseRepository;
  
  @Autowired
  private CourseRegistrationRepository courseResgistrationRepository;
  
  public static void main(String[] args) {
    SpringApplication.run(AdmApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Rodando CommandLineRunner");
    
    User student1 = new User(null, "Victor Hugo da Costa Leite", "11039215");
    User student2 = new User(null, "Fabio Mendes Milanez", "11040315");
    User student3 = new User(null, "Henrique de Toledo", "11040315");
    User student4 = new User(null, "Bruno Bevilacqua Nascimento", "11041315");
    User student5 = new User(null, "Renan Baisso", "11064215");
    
    userRepository.saveAll(Arrays.asList(student1, student2, student3, student4, student5));
    
    Course course1 = new Course(null, "Engenharia de Informação");
    Course course2 = new Course(null, "Engenharia de instrumentação, Automação e Robótica");
    Course course3 = new Course(null, "Fisica");
    Course course4 = new Course(null, "Matemátia");
    Course course5 = new Course(null, "Ciências da Computação");
    
    courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4, course5));
    
    CourseRegistration cr1 = new CourseRegistration(student1, course1);
    CourseRegistration cr2 = new CourseRegistration(student2, course2);
    CourseRegistration cr3 = new CourseRegistration(student3, course2);
    CourseRegistration cr4 = new CourseRegistration(student4, course2);
    CourseRegistration cr5 = new CourseRegistration(student5, course1);
    
    courseResgistrationRepository.saveAll(Arrays.asList(cr1, cr2, cr3, cr4, cr5));
  }
  
}
