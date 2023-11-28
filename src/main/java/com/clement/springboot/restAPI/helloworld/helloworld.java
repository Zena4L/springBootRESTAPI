package com.clement.springboot.restAPI.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

    @GetMapping(path = "/hello")
    public String helloWorld(){
        return  "Hello World!";
    }
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world!!");
    }
    @GetMapping(path = "hello-world/{name}")
    public HelloWorldBean helloWorldVariable(@PathVariable String name){
        return new HelloWorldBean("Welcome " + name);
    }

}
