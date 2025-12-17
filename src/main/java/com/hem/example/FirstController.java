package com.hem.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class FirstController {
  @GetMapping("/hello")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public String sayHello() {
      return "Hello from first controller";
  }

  @PostMapping("/post")
  public String postString(@RequestBody String message) {
      return "Request Accepted " + message ;
  }
  
  
}
