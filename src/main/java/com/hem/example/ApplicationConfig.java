package com.hem.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.hem.example.Test.MyFirstClass;

@Configuration
@Profile("dev")
public class ApplicationConfig {
  
	@Bean("bean1") //("myFirstClass") also can user function name
	// @Profile("prod")
	public MyFirstClass myFirstBen(){
		return new MyFirstClass("Frist bean");
  }
	
	@Bean //("myFirstClass") also can user function name
	// @Profile("env")
	public MyFirstClass mySecondBen(){
		return new MyFirstClass("Second bean");
  }

	@Bean //("myFirstClass") also can user function name
	// @Primary
	public MyFirstClass myThirdBen(){
		return new MyFirstClass("Third bean");
  }

	
	
}
