package com.hem.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import com.hem.example.Test.MyFirstClass;

@Service
// @PropertySource("classpath:custom.properties") // for adding single custom properties file
@PropertySources({
  @PropertySource("classpath:custom.properties"),
  @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

  private final MyFirstClass myFirstClass;

  // @Value("Hello learning application")
  // private String customProperties;

  @Value("${my.prop}")
  private String customPropertyFormAnotherFile;

   @Value("${my.prop.2}")
  private String customPropertyFormAnotherFile2;

  // @Value("123")
  // private Integer customPropertyInt;


  @Value("${my.custom.properties}")
  private String customProperties;

    @Value("${my.custom.properties.int}")
  private String customPropertiesInt;

  //Constructor injection
  public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass){
    this.myFirstClass = myFirstClass;
  }

  public String tellAStory(){
    return "The dependency is saying : " + myFirstClass.sayHello();
  }

  public String getCustomPropertyFormAnotherFile(){
    return customPropertyFormAnotherFile;
  }

  public String getCustomPropertyFormAnotherFile2(){
    return customPropertyFormAnotherFile2;
  }

  public String getCustomProperties(){
    return customProperties;
  }

  public String getCustomPropertiesInt(){
    return customPropertiesInt;
  }
  
}
