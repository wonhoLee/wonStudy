package me.won.effectivejava3rd.item01;

import java.util.EnumSet;

import org.springframework.boot.SpringApplication;

public class Foo {
	String name;
	String address;
	
	public Foo() { }
	
	public Foo(String name) {
		this.name = name;
	}
	
	//장점1
	public static Foo withName(String name) {
		return new Foo(name);
	}
	
	//장점1
	public static Foo withAddress(String address) {
		Foo foo = new Foo();
		foo.address = address;
		return foo;
	}
	
	//장점2
	private static final Foo GODO_NIGHT = new Foo();
	public static Foo getFoo() {
		return GODO_NIGHT;
	}
	
	//장점3
	public static Foo getFoo(boolean flag) {
		return flag ? new Foo() : new BarFoo();
	}
	static class BarFoo extends Foo{
	}
	
	//장점5
	public static Foo getFoo(boolean flag, boolean five) {
		Foo foo = new Foo();
		
		// TODO 어떤 특정 약속 되어 있는 텍스트 파일에서 Foo의 구현체의 FQCN을 읽어온다.
		// TODO FQCN 에 해당하는 인스턴스를 생성한다.
		// TODO foo 변수를 해당 인스턴스를 가리키도록 수정한다.

		return foo;
	}
	
	public static void main(String[] args) {
		Foo foo = new Foo("test");
		Foo foo1 = Foo.withName("test2");
		Foo foo2 = Foo.getFoo();
		Foo foo3 = Foo.getFoo(false);
		
		EnumSet<Color> colors = EnumSet.allOf(Color.class);
		
		EnumSet<Color> blueAndWhtie = EnumSet.of(Color.BLUE, Color.WHITE);
	}
	
	//장점4
	enum Color{
		RED, BLUE, WHITE
	}
	
	//단점2
	public static void test() {
		//SpringApplication.run();	//SpringApplication 상의 주석 확인용
	}
	
	//Private static method가 필요한이유
	public static void doSomething() {
		//TODO Doing1
		doGameAndSleep();
	}
	
	public void doSomethingTomorrow() {
		//TODO 밥을먹는다.
		doGameAndSleep();
	}
	
	private static void doGameAndSleep() {
		//TODO 게임을한다
		//TODO 잔다
	}
}


