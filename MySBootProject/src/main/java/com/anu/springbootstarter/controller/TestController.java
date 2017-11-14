package com.anu.springbootstarter.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/hai")
	public String sayHello(){
		return "Hello, This is my Spring Boot project";
	}

}
