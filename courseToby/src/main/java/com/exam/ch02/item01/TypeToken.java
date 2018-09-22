package com.exam.ch02.item01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeToken {
	/* case 00
	static Object create() {
		return new Object();
	}
	
	public static void main(String[] args) throws Exception {
		Object o = create();
		System.out.println(o.getClass());
	}
	*/
	
	/*	case 01
	static <T> T createT(Class<T> clarr) throws Exception {
		return clarr.newInstance();
	}
	
	public static void main(String[] args) throws Exception {
		String o = createT(String.class);
		System.out.println(o.getClass());
	}
	
	*/
	
	//case 02
	
	/*static class Generic<T> {
		T value;
		void set(T t) {}
		T get() {return null;}
	}
	
	public static void main(String[] args) {
		Generic<String> s = new Generic<>();
		s.value = "string test";
		
		Generic<Integer> i = new Generic<>();
		i.value = 1;
		i.set(10);
		
	}*/
	
	//case 03
	/*static class TypeSafeMap {
		Map<String, Object> map = new HashMap<>();
		void run() {
			map.put("a", "a");
			map.put("b", 1);
			Integer i = (Integer) map.get("b");	// 피하는게 좋음
		}
	}*/
	
	//case 04 : Type Token
	/* worst case
	 * static class TypeSafeMap {
		Map<Class<?>, Object> map = new HashMap<>();
		void put(Class<?> clazz, Object value) {
			map.put(clazz, value);
		}
	}
	 */
	
	//Best Case
	static class TypeSafeMap {
		Map<Class<?>, Object> map = new HashMap<>();
		<T> void put(Class<T> clazz, T value) {
			map.put(clazz, value);
		}
		
		<T> T get(Class<T> clazz) {
			return clazz.cast(map.get(clazz));
		}
	}
	
	public static void main(String[] args) {
		TypeSafeMap m = new TypeSafeMap();
		//m.put(String.class,  "Value");
		//m.put(Integer.class,  1);
		//m.put(List.class,  Arrays.asList(1,2,3));
		
		//Type Token의 한계
		m.put(List.class,  Arrays.asList(1,2,3));		//List<Integer>
		m.put(List.class,  Arrays.asList("1","2","c"));	//List<String>
		
	}
}
