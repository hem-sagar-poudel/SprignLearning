package com.hem.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hem.example.Test.MyFirstClass;

@Service
public class MyFirstService {

  private final MyFirstClass myFirstClass;
  // auto wired will be done by spring framework inf 
  // constructor has params of beans class
  public MyFirstService(MyFirstClass myFirstClass){
    this.myFirstClass = myFirstClass;
  }

  public String tellAStory(){
    return "The dependency is saying : " + myFirstClass.sayHello();
  }
}
