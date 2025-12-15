package com.hem.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.hem.example.Test.MyFirstClass;

@Configuration
public class ApplicationConfig {
  
	@Bean //("myFirstClass") also can user function name
	public MyFirstClass myFirstBen(){
		return new MyFirstClass("Frist bean");
  }

	@Bean //("myFirstClass") also can user function name
	public MyFirstClass mySecondBen(){
		return new MyFirstClass("Second bean");
  }

	@Bean //("myFirstClass") also can user function name
	@Primary
	public MyFirstClass myThirdBen(){
		return new MyFirstClass("Third bean");
  }

	
	
}
