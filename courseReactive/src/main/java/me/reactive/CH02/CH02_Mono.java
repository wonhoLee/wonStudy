package me.reactive.CH02;

import reactor.core.publisher.Mono;

public class CH02_Mono {
	//========================================================================================

		// TODO Return an empty Mono
		Mono<String> emptyMono() {
			return Mono.empty();
		}

	//========================================================================================

		// TODO Return a Mono that never emits any signal
		Mono<String> monoWithNoSignal() {
			return Mono.never();
		}

	//========================================================================================

		// TODO Return a Mono that contains a "foo" value
		Mono<String> fooMono() {
			return Mono.just("foo");
		}

	//========================================================================================

		// TODO Create a Mono that emits an IllegalStateException
		Mono<String> errorMono() {
			return Mono.error(new IllegalStateException());
		}

		
		public static void main(String[] args) {
			Mono.just(1);
		}
}
