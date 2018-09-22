package com.exam.ch02.item02;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/ch02")
	public List<User> users(){
		return Arrays.asList(new User("A"), new User("B"), new User("C"));
	}
}