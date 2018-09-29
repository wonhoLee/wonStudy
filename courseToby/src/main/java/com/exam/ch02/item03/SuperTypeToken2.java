package com.exam.ch02.item03;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ResolvableType;

import com.exam.ch02.item03.SuperTypeToken2.TypeReference;

/*2.5회
 * 기존 라이브코딩 예제 SuperTypeToken2 클래스 좋은 접근법이 아니였음 -> 효율적으로 개선 필요
 * 
*/
public class SuperTypeToken2 {
	static class TypeSafeMap {
		Map<Type, Object> map = new HashMap<>();
		
		<T> void put(TypeReference<T> tr, T value) {
			map.put(tr.type, value);
		}
		
		@SuppressWarnings({ "unchecked"})
		<T> T get(TypeReference<T> tr) {
			if(tr.type instanceof Class<?>)
				return ((Class<T>)tr.type).cast(map.get(tr.type));	//TypeReference<String> 동작
			else
				return ((Class<T>)((ParameterizedType)tr.type).getRawType()).cast(map.get(tr.type));	//TR<LIST<STRING>> 
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
		
		//Type Token의 한계 -> SuperTypeToken 으로 해결
		m.put(new TypeReference<List<Integer>>() {},  Arrays.asList(1,2,3));		//List<Integer>
		m.put(new TypeReference<List<String>>() {},  Arrays.asList("1","2","c"));	//List<String>
		
		System.out.println(m.get(new TypeReference<List<Integer>>() {}));
		System.out.println(m.get(new TypeReference<List<String>>() {}));
	
		//Spring 4.0 이상에서 SuperTypeToken 관련 사용하는 케이스
		//ResolvableType 통해 간단히 구현가능
		//자세한건 ResolvableType 클래스 학습할것
		//ResolvableType rt = ResolvableType.forClass(TypeReference.class);
		ResolvableType rt = ResolvableType.forInstance(new TypeReference<List<String>>() {});
		System.out.println(rt.getSuperType().getGenerics().length);
		System.out.println(rt.getSuperType().getGeneric(0).getType());
		System.out.println(rt.getSuperType().getGeneric(0).getNested(1).getType());
		System.out.println(rt.getSuperType().getGeneric(0).getNested(2).getType());
		
	}
}
