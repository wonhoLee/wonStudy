package me.reactive.CH06;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CH06Add {
	/*@Test
	public void reactorStudy() throws InterruptedException {
		Flux<Long> flux = Flux.interval(Duration.ofMillis(100)).take(4).log();
		
		//데몬쓰레드가 뜨는 구조
		//데몬쓰레드는 유저쓰레드가 하나도 안남으면 죽음
//		flux.doOnNext(System.out::println)
//			.subscribe();
		
		//마지막을 기다림
//		flux.doOnNext(System.out::println)
//			.blockLast();
		System.out.println(Thread.currentThread().getName());
		
		flux.doOnNext(v -> {
			System.out.println(v);
			//System.out.println(Thread.currentThread().getName());
		})
			.blockLast();
		
		//Thread.sleep(1000l);	//1초
	}*/
	
	@Test
	public void reactorStudy2() {
		Flux<Integer> flux = Flux.range(0, 3).log();
		
		Flux<Integer> flux2 = Flux.range(0, 3).take(2).log();
		
		//flux.subscribe();
		
		StepVerifier.create(flux, 1)
				.expectNext(0)
				.thenRequest(1)
				.expectNext(1)
				.thenRequest(2)
				.expectNext(2)
				.verifyComplete();
		
//		StepVerifier.create(flux, 1)
//			.expectNext(0)
//			.thenRequest(1)
//			.expectNext(1)
//			.thenCancel()
//			.verify()
//			;
		
		
	}
}
