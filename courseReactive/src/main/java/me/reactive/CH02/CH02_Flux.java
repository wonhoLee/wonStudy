package me.reactive.CH02;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import reactor.core.publisher.Flux;

public class CH02_Flux {
	//========================================================================================

		// TODO Return an empty Flux
		Flux<String> emptyFlux() {
		    return Flux.empty();
		}

	//========================================================================================

		// TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
		Flux<String> fooBarFluxFromValues() {
			return Flux.just("foo", "bar");
		}

	//========================================================================================

		// TODO Create a Flux from a List that contains 2 values "foo" and "bar"
		Flux<String> fooBarFluxFromList() {
			//return Flux.fromIterable(Arrays.asList("foo", "bar"));
			return Flux.fromIterable(List.of("foo", "bar"));
		}

	//========================================================================================

		// TODO Create a Flux that emits an IllegalStateException
		Flux<String> errorFlux() {
			return Flux.error(new IllegalStateException());
		}

	//========================================================================================

		// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
		Flux<Long> counter() {
			return null;
		}
		
		public static void main(String[] args) throws InterruptedException {
			Flux.fromIterable(Arrays.asList("foo", "bar"))
				.doOnNext(System.out::println)
				.map(String::toUpperCase)
				.subscribe(System.out::println);
			
			System.out.println("test!!!!!!!");
			
			Flux.error(new IllegalStateException())
				.doOnError(System.out::println)
				.subscribe();
			
			Flux.interval(Duration.ofMillis(100))
				.take(10)
				.subscribe(System.out::println);
			
			//Thread.sleep(5000);
				
		}
}
