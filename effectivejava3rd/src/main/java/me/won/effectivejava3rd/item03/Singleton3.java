package me.won.effectivejava3rd.item03;

import java.io.Serializable;

//직렬화
public class Singleton3 implements Serializable{
	private static final Singleton3 INSTANCE = new Singleton3();
	
	private Singleton3() {
		
	}
	
	public static Singleton3 getInstance() {
		return INSTANCE;
	}
}
