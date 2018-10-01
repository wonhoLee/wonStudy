package com.exam.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics6 {
	static class A{}
	static class B extends A{}
	
	static void print(List<? extends Object> list) {}
	
	public static void main(String[] args) {
		List<B> listB = new ArrayList<>();
		//List<A> listA = listB;			//상속관계 아니라 불가
		List<? extends A> listA = listB;	//가능
		List<? super B> l2 = listB;
		//선언은 가능하나 사용에 제약이 있음
		//listA.add(new A());	//불가
		listA.add(null);	//null은 가능
		
		//Collections 연결된 관련 함수 보면 다양하게 사용중임
		//이 차이점은 다음 방송때 설명
		//Collections.en
		
		//질문응대
		List<Integer> listInt = Arrays.asList(1,2,3);
		print(listInt); //가능
	}
}
