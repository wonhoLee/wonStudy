package com.exam.ch02.item01;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SuperTypeToken {
	static class Sup<T> {
		T value;
	}
	
	//NESTED STATIC CLASS = INNER CLASS??
	static class Sub extends Sup<String> {
		
	}
	
	static class Sub2 extends Sup<List<String>> {
		
	}

	public static void main(String[] args) throws NoSuchFieldException {
		//CASE1 class java.lang.Object 출력됨
		/*Sup<String> s = new Sup<>();
		System.out.println(s.getClass().getDeclaredField("value").getType());*/

		//CASE2	class java.lang.String 출력됨
		//Type 정보를 정확히 가져옴
		/*Sub b = new Sub();
		Type t = b.getClass().getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) t;
		System.out.println(ptype.getActualTypeArguments()[0]);
		
		Sub2 c = new Sub2();
		System.out.println(((ParameterizedType) c.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);*/
		
		//CASE3 LOCAL CLASS
		// 동일하게 TYPE 정보 가져옴
		/*class Sub3 extends Sup<List<String>> {
			
		}
		
		Sub3 d = new Sub3();
		System.out.println(((ParameterizedType) d.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);*/
		
		//CASE4 ANONYMOUS CLASS
		// 동일하게 TYPE 정보 가져옴
		Sup<List<String>> Sub3 = new Sup<List<String>>(){};
		System.out.println(((ParameterizedType) Sub3.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		
	}
}
