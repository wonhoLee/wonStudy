package com.exam.ch05;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Observer 패턴 설명
 */
/*
 * Observer 패턴의 한계
 * 1. 데이터의 끝이 어디인지 모름
 *  - 데이터 마지막에 Complete 같은 문자를 넣는등의 처리를 해줘야 함
 *  - 하지만 해당 방법도 외부데이터를 받아오는것에는 한계가 있음
 * 2. Exception(Error) 이 발생할때
 *  - 버그는 해결이 가능하지만 일시적인 예외사항이 발생할수도 있음
 *  - 버그나 예외처리 같은것이 불가능함
 *  
 *  -> 확장된 Oberver 패턴이 observable
 *   - React 의 3개의 축중 하나
 *   http://www.reactive-streams.org/
 *   reactivex.io
 */
@SuppressWarnings("deprecation")
public class ReactiveEx02 {
	
	static class IntObservable extends Observable implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				setChanged();
				notifyObservers(i);
			}
		}
	}
	
	public static void main(String[] args) {
		//Source -> Event/Data -> Observer
		Observer ob = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				System.out.println(Thread.currentThread().getName() + " " + arg);
			}
		};
		
		IntObservable io = new IntObservable();
		io.addObserver(ob);
		//io.run();
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(io);
		
		System.out.println(Thread.currentThread().getName() + " : EXIT");
		es.shutdown();
	}
}
