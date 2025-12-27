package com.hem.example;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class FirstController {
 
  public final StudentRepository studentRepository;

  public FirstController(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
  }

  @PostMapping("/students")
  public Student postStudent(@RequestBody Student students) {
      return studentRepository.save(students);
  }

  @GetMapping("/students/{student-id}")
  public Student getStudent(@PathVariable("student-id") Integer id) {
      return studentRepository.findById(id).orElse(new Student());
  }

  @GetMapping("/students")
  public List<Student> getAllStudent() {
      return studentRepository.findAll();
  }

  @GetMapping("/students/search/{student-name}")
  public List<Student> getStudentsByName(@PathVariable("student-name") String name) {
      return studentRepository.findAllByFirstnameContaining(name);
  }

  @DeleteMapping("/students/{student-id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteStudentsByName(@PathVariable("student-id") Integer id) {
     studentRepository.deleteById(id);
  }

}
