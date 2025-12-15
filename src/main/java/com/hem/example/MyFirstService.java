package com.hem.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hem.example.Test.MyFirstClass;

@Service
public class MyFirstService {

  private MyFirstClass myFirstClass;

  // setter injection
  @Autowired
 // @Qualifier("bean1") can be here also
  public void setMyFirstClass( @Qualifier("bean1") MyFirstClass myFirstClass){
    this.myFirstClass = myFirstClass;
  }

  public String tellAStory(){
    return "The dependency is saying : " + myFirstClass.sayHello();
  }
}
