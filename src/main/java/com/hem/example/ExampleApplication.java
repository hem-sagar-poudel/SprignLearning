package com.hem.example;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var context = app.run();

		// can user bean name or function name as name param
		MyFirstService first = context.getBean(MyFirstService.class);
		System.out.println(first.tellAStory());
		System.out.println(first.getCustomPropertyFormAnotherFile());
		System.out.println(first.getCustomPropertyFormAnotherFile2());
		System.out.println(first.getCustomProperties());
		System.out.println(first.getCustomPropertiesInt());

	}


}
