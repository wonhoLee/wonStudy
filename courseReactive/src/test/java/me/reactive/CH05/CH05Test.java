package me.reactive.CH05;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH05Test {

	@Test
	public void test() {
//		Flux<Long> flux1 = Flux.interval(Duration.ofMillis(100)).take(10);
//		Flux<Long> flux2 = Flux.just(100l, 101l, 102l);
		
//		flux1.mergeWith(flux2)
//			.doOnNext(System.out::println)
//			.blockLast();
		
//		flux1.concatWith(flux2)
//		.doOnNext(System.out::println)
//		.blockLast();
		
		Mono<Long> mono1 = Mono.just(5l);
		Mono<Long> mono2 = Mono.just(1l);
		
//		Flux.merge(mono1, mono2)
//			.doOnNext(System.out::println)
//			.blockLast();
		
		Flux.concat(mono1, mono2)
			.doOnNext(System.out::println)
			.blockLast();
	}

}
