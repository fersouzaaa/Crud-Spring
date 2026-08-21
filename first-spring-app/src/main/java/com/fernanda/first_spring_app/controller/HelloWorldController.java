package com.fernanda.first_spring_app.controller;

import com.fernanda.first_spring_app.domain.User;
import com.fernanda.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //indica que essa classe é um controller rest
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    //GET /hello-world
    @GetMapping
    public String helloWorld(){
        return helloWorldService.helloWord("Fernanda Souza");
    }

    @PostMapping("")
    public String helloWorldPost(@RequestBody User body){

        return "Hello World " + body.getName() + " " + body.getEmail();
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable String id, @RequestBody User body, @RequestParam(value = "filter", defaultValue = "nenhum") String filter){
        return "Hello World "+ filter;
    }
}
