package com.exam.ch02.item02;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class SpringTypeReference {
	public static void main(String[] args) {
		//spring 3.2 이상에서 사용가능
		ParameterizedTypeReference<List<Map<Set<Integer>, String>>> typeRef = new ParameterizedTypeReference<List<Map<Set<Integer>, String>>>() {
		};
		
		System.out.println(typeRef.getType());
		
		
		//spring 예제
		//BAD CASE : LinkedHaspMap으로 강제 캐스팅 되는것을 확인할수 있음
		/*RestTemplate rt = new RestTemplate();
		List<User> users = rt.getForObject("http://localhost:8080/ch02",  List.class);
		System.out.println(users.get(0).getName());*/

		//GOOD CASE
		RestTemplate rt = new RestTemplate();
		List<User> users = rt.exchange("http://localhost:8080/ch02", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>(){}).getBody();
		System.out.println(users.get(0).getName());
		users.forEach(System.out::println);
	}

}
