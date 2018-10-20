package me.reactive.CH01;

import reactor.core.publisher.Flux;

public class CH01 {
	public static void main(String[] args) {
		Flux<String> flux = Flux.just("A");
		flux.map(s -> "foo" + s);
		flux.subscribe(System.out::println);
		
		flux.map(s -> "foo" + s).subscribe(System.out::println);
		
		Flux<String> flux2 = flux.map(s -> "foo" + s);
		flux2.subscribe(System.out::println);
	}
}
