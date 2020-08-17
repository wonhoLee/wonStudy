package com.example;

import org.aspectj.lang.Aspects;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InterceptorApplication {

	@RequestMapping("/")
	@MaskingAnno
	public String home() {
		return "Hello World";
	}
	
	@RequestMapping("/demo")
	@MaskingAnno
	public String demo(String text) {
		DemoDto demoDto = new DemoDto();
		demoDto.setUserName(text);
		return "Hello World " + demoDto.getUserName();
	}

	@Bean
	public Interceptor interceptor() {
		// This will barf at runtime if the weaver isn't working (probably a
		// good thing)
		return Aspects.aspectOf(Interceptor.class);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(InterceptorApplication.class).run(args);
	}
}
