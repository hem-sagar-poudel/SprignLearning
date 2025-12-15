package com.hem.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hem.example.Test.MyFirstClass;

@Configuration
public class ApplicationConfig {
  
	@Bean //("myFirstClass") also can user function name
	@Qualifier("bean1")
	public MyFirstClass myFirstBen(){
		
		return new MyFirstClass("Sumit");
  }

	@Bean //("myFirstClass") also can user function name
	@Qualifier("bean2")
	public MyFirstClass mySecondBen(){
		
		return new MyFirstClass("Sumit");
  }
	
}
