package com.hem.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @PostMapping("/post-order")
  // this is using POJOS // plane old java objects
  public String postOrder(@RequestBody Order order) {
      return "Request Accepted and order is " + order.toString(); // object order is converted to string
  }

  @PostMapping("/post-order-record")
  // DTOS // Data Transfer objects // Java Records introduced in 14 and finalized in 16
  // Record class is immutable // carry fixed set of values
  // all fields are automatically final
  public String postOrderRecord(@RequestBody OrderRecord orderRecord) {
    return "Request Accepted and order is " + orderRecord.toString(); // object order is converted to string
  }

  //localhost:8080/hello/john
  @GetMapping("/hello/{user-name}") //or make same path variable in all
  public String pathVar(@PathVariable("user-name") String userName ) {
      return "my value = " + userName;
  }

  //localhost:8080/hello/john
  @GetMapping("/hello/{userName}/path") //or make same path variable in all
  public String pathVarTest(@PathVariable String userName ) {
      return "my value = " + userName;
  }


  //localhost:8080/hello/?name=john
  @GetMapping("/hello/test") //or make same path variable in all
  public String pathVarTests(@RequestParam("name") String name, @RequestParam("token") String token ) {
      return "my value = " + name + " " + token;
  }

}
