package me.won.effectivejava3rd.item03;

//static 팩토리 메소드
public class Singleton2 {
	private static final Singleton2 INSTANCE = new Singleton2();
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
}
