package me.won.effectivejava3rd.item03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTest {
	public static void main(String[] args) {
		//Singleton 이기 때문에 new 는 불가 
		//Singleton1 singleton1 = new Singleton1();
		
		//final필드
		Singleton1 singleton1 = Singleton1.INSTANCE;
		
		//reflection 실습
		/*Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton1 singleton12 = (Singleton1)constructor.newInstance();
		System.out.println(singleton12.toString());*/
		
		Constructor<Singleton1> constructor = null;
		try {
			constructor = Singleton1.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			Singleton1 singleton12;
			singleton12 = (Singleton1)constructor.newInstance();
			
			System.out.println(singleton12.toString());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		//static 팩토리 메소드
		Singleton2 singleton2 = Singleton2.getInstance();
		
		Supplier<Singleton2> s2supplier = Singleton2::getInstance;
		
		//직렬화
		//역직렬화시 싱글톤 깨질수 있음
		//방어코드는 교재
		//직렬화 사용하는 케이스 : 네트워크 통신, 저장소에 저장했다 꺼낼때, Json 변환, Object 변환 등
		
		//Enum
		Singleton4 singleton4 = Singleton4.INSTANCE;
		System.out.println("singleton4 : " + singleton4.getName());
		
		//spring 에서
		//spring 에서 현실적인 케이스
		//UserService 안에서는 Singleton이지만 userService 자체를 새로 생성하면 Singleton이 아님
		UserService userService1 = new UserService();
		UserService userService2 = new UserService();
		
		System.out.println("spring case 1 : " + (userService1 == userService2));
		
		//ApplicationContext 를 이용하여 싱글톤으로 할수있지만 이런 케이스는 드뭄
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		UserService userService3 = applicationContext.getBean(UserService.class);
		UserService userService4 = applicationContext.getBean(UserService.class);
		
		System.out.println("spring case 2 : " + (userService3 == userService4));
		
		//ApplicationContext 방식이여도 싱글톤 아니게 할수 있음
		//UserService2 자체에 @Scope 어노테이션을 사용하면 됨 하지만 이런 케이스 역시 드뭄
		UserService2 userService21 = applicationContext.getBean(UserService2.class);
		UserService2 userService22 = applicationContext.getBean(UserService2.class);
		
		System.out.println("spring case 3 : " + (userService21 == userService22));
	}
}
