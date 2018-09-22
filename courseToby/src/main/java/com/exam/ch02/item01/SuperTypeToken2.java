package com.exam.ch02.item01;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperTypeToken2 {
	static class TypeSafeMap {
		Map<TypeReference<?>, Object> map = new HashMap<>();
		<T> void put(TypeReference<T> tr, T value) {
			map.put(tr, value);
		}
		
		@SuppressWarnings({ "unchecked"})
		<T> T get(TypeReference<T> tr) {
			if(tr.type instanceof Class<?>)
				return ((Class<T>)tr.type).cast(map.get(tr));	//TypeReference<String> 동작
			else
				return ((Class<T>)((ParameterizedType)tr.type).getRawType()).cast(map.get(tr));	//TR<LIST<STRING>> 
		}
	}
	
	static class TypeReference<T> {
		Type type;
		
		public TypeReference() {
			Type stype = getClass().getGenericSuperclass();
			if(stype instanceof ParameterizedType) {
				this.type = ((ParameterizedType) stype).getActualTypeArguments()[0];
			}else
				throw new RuntimeException();
		}

		// equals 를 만들어 줄꺼면 hashcode를 같이 만들어줘야함
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass().getSuperclass() != obj.getClass().getSuperclass())
				return false;
			TypeReference<?> other = (TypeReference<?>) obj;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		//Type 정보 정확히 가지고 있음
		/*TypeReference<String> t = new TypeReference<String>() {};
		System.out.println(t.type);*/
				
		TypeSafeMap m = new TypeSafeMap();
		TypeReference<Integer> trInt = new TypeReference<Integer>() {};
		m.put(trInt,  1);
		m.put(new TypeReference<String>() {},  "Value");
		m.put(new TypeReference<List>() {},  Arrays.asList(1,2,3));
		
		System.out.println(m.get(trInt));
		System.out.println(m.get(new TypeReference<String>() {}));
		System.out.println(m.get(new TypeReference<List>() {}));
		
		//Type Token의 한계
		m.put(new TypeReference<List<Integer>>() {},  Arrays.asList(1,2,3));		//List<Integer>
		m.put(new TypeReference<List<String>>() {},  Arrays.asList("1","2","c"));	//List<String>
		
		System.out.println(m.get(new TypeReference<List<Integer>>() {}));
		System.out.println(m.get(new TypeReference<List<String>>() {}));
		
	}
}
