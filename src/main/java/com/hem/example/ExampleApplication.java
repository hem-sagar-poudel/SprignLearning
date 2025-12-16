package com.hem.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ExampleApplication.class, args);

		// can user bean name or function name as name param
		MyFirstService first = context.getBean(MyFirstService.class);
		System.out.println(first.tellAStory());
		System.out.println(first.getCustomPropertyFormAnotherFile());
		System.out.println(first.getCustomPropertyFormAnotherFile2());
		System.out.println(first.getCustomProperties());
		System.out.println(first.getCustomPropertiesInt());

	}


}
