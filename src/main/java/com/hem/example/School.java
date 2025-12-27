package com.hem.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="T_SCHOOL")
public class School {
 
  @Id
  @GeneratedValue
  private Integer id;
 
  @Column(length = 50)
  private String name;

  //------------------------------------

  @OneToMany(mappedBy = "school")
  @JsonManagedReference
  private List<Student> student;

 //------------------------------------

  public School(){}

  public School(String name){
    this.name = name;
  }

  //------------------------------------

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

  public List<Student> getStudent() {
    return student;
  }

  public void setStudent(List<Student> student) {
    this.student = student;
  }
}
