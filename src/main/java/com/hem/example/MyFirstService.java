package com.hem.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hem.example.Test.MyFirstClass;

@Service
public class MyFirstService {

  // field injection is not recommended
  @Autowired 
  // should not be final
  @Qualifier("bean1") // access function name as qualifier
  private MyFirstClass myFirstClass;


  public String tellAStory(){
    return "The dependency is saying : " + myFirstClass.sayHello();
  }
}
