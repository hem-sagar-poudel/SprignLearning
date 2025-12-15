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

### this service will access primary bean

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
