package com.hem.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.hem.example.Test.MyFirstClass;

@Service
public class MyFirstService {

  private MyFirstClass myFirstClass;
  private Environment environment;

 

 




   // setter injection
  @Autowired
 // @Qualifier("bean1") can be here also
  public void setMyFirstClass( @Qualifier("bean1") MyFirstClass myFirstClass){
    this.myFirstClass = myFirstClass;
  }

  public String tellAStory(){
    return "The dependency is saying : " + myFirstClass.sayHello();
  }
  



  @Autowired
  public void setEnvironment(Environment environment){
    this.environment = environment;
  }

  public String getJavaVersion(){
    return environment.getProperty("java.version");
  }

  public String getOsName(){
    return environment.getProperty("os.name");
  }

  // accessed form application.properties
  public String getProperties(){
    return environment.getProperty("my.custom.properties");
  }
}
