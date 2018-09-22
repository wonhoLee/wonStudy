package me.won.item07;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheSample {
	
	public static void main(String[] args) {
		Object key1 = new Object();
		Object value1 = new Object();
		
		Map<Object, Object> cache = new HashMap<>();
		cache.put(key1, value1);
		
		Map<Object, Object> testCache = new WeakHashMap<>();
		testCache.put(key1,  value1);
		//하드 레퍼런스가 쓸모없어지면 위크레퍼런스가 정리가 됨

		//콜백목록 관리시 weakHashMap을 사용하기도 함
		//Key에대한 내용이 사라지면 MapEntry를 자동으로 비움

		//Strong, weak(soft, phantom)
		//strong 레퍼런스가 쓸모없어지면 weakReference 는 GC 대상이 됨

		//어디선가 Key1이 쓸모없어지면 HashMap으로 들고있으면 HashMap을 비우지 않으면 GC대상이 안됨
		//WeakHashMap으로 들고있으면 Key1 이 쓸모없어지는 순간 GC대상이 됨
	}

}
