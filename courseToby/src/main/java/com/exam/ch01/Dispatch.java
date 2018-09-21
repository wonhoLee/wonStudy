package com.exam.ch01;

import java.util.Arrays;
import java.util.List;

public class Dispatch {
	//static dispatch
	static class Service {
		void run() {
			System.out.println("run()");
		}
		
		void run(String msg) {
			System.out.println("msgRun(" + msg + ")");
		}
		
		void run(int number) {
			System.out.println("numRun(" + number + ")");
		}
	}
	
	static abstract class Service2 {
		abstract void run();
	}
	
	static class MyService1 extends Service2 {
		@Override
		void run() {
			System.out.println("run1");
		}
	}
	
	static class MyService2 extends Service2 {
		@Override
		void run() {
			System.out.println("run2");
		}
	}
	
	public static void main(String[] args) {
		//static dispatch
		new Service().run();
		new Service().run("Dispatch");
		new Service().run(1);
		System.out.println("");
		
		MyService1 svc1 = new MyService1();
		svc1.run();
		MyService2 svc2 = new MyService2();
		svc2.run();
		System.out.println("");
		
		//daynamic dispatch
		Service2 svc = new MyService1();
		svc.run();	// receiver parameter
		System.out.println("");
		
		List<Service2> listSvc = Arrays.asList(new MyService1(), new MyService2());
		//listSvc.forEach(s -> s.run());
		listSvc.forEach(Service2::run);
		
		
	}
}
