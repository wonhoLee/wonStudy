package com.exam;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.util.concurrent.CompleteFuture;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class CourseTobyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseTobyApplication.class, args);
		
		/*아래 try with resource 이외에 이와같이 쓸수도 있음
		 * ConfigurableApplicationContext c = SpringApplication.run(CourseTobyApplication.class, args);
		 * c.getBean(sbApplication.class);
		c.close();*/
		
	}
	
	@RestController
	public static class MyController{
		
		// HTTP Request : 3, 메소드 URI 프로토콜버전, 헤더, 엔티티
		// HTTP Reponse : 3, status code, header, Body -> return value
		
		@RequestMapping("/hello")
		public String hello() {
			return "<h1>hello world</h1>";
		}
		
		//Reactive
		@RequestMapping("/hellor")
		public Mono<String> hellor() {
			/*return Mono
					.just("Hello Reactive");*/
			return Mono
					.just("Hello Reactive")
					.map(s->s.toUpperCase())
					.publishOn(Schedulers.newSingle("publishOn"))
					.log();
		}
		
		//Spring 4에서 들어간 CompletableFuture 이용
		@RequestMapping("/helloc")
		public CompletableFuture<String> helloc(){
			return CompletableFuture
					.supplyAsync(()->"Hello World C")
					.thenApplyAsync(s->s.toUpperCase());
		}
	}
	
	//Try with resource 사용하여
	//다른 빈들 Autowired 로 끌어와 사용해보는 코드 작성가능
	// ->테스트 이후 종료하는 식
	//인자값 전달도 가능함
	/*public static void main(String[] args) {
		try(ConfigurableApplicationContext c = SpringApplication.run(CourseTobyApplication.class, args)){
			
		}
	}*/
	
	//최초 설명 : 강의 시작 1년전쯤 강의함
	/*@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("run()...");
			}
		}; 
	}*/
	
	//@Autowired UserRepository userRepository;
	
	//현재 추천 하는 방법
	/*@Bean
	public ApplicationRunner run() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				//userRepository.save();
				System.out.println("run()...");
			}
		};
		
		//람다식
		return (args) -> System.out.println("run()...");
	}*/
}
