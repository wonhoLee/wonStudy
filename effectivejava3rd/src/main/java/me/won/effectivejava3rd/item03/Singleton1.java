package me.won.effectivejava3rd.item03;

//final필드 방법
public class Singleton1 {
	public static final Singleton1 INSTANCE = new Singleton1();

	int count;
	
	private Singleton1() {
		count++;
		if(count != 1) {
			throw new IllegalStateException("this object should be singleton");
		}
	}

	@Override
	public String toString() {
		return "Singleton1 [count=" + count + "]";
	}
	
	
}
