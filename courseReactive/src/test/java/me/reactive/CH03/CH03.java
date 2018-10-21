package me.reactive.CH03;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.function.Supplier;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CH03 {

	//========================================================================================

		// TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then completes successfully.
		void expectFooBarComplete(Flux<String> flux) {
			StepVerifier.create(flux)
			    .expectNext("foo")
			    .expectNext("bar")
			    .verifyComplete();
		}

	//========================================================================================

		// TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then a RuntimeException error.
		void expectFooBarError(Flux<String> flux) {
			StepVerifier.create(flux)
			        .expectNext("foo")
			        .expectNext("bar")
			        .verifyError(RuntimeException.class);
		}

	//========================================================================================

		// TODO Use StepVerifier to check that the flux parameter emits a User with "swhite"username
		// and another one with "jpinkman" then completes successfully.
		public static class User{
			private String userName;

			public User(String userName) {
				super();
				this.userName = userName;
			}

			public String getUserName() {
				return userName;
			}
		}
		
		void expectSkylerJesseComplete(Flux<User> flux) {
			StepVerifier.create(flux)
				.assertNext(s -> assertThat(s.getUserName()).isEqualTo("swhite"))
				.assertNext(s -> assertThat(s.getUserName()).isEqualTo("jpinkman"))
				.verifyComplete();
		}

	//========================================================================================

		// TODO Expect 10 elements then complete and notice how long the test takes.
		void expect10Elements(Flux<Long> flux) {
			StepVerifier.create(flux)
					.expectNextCount(10)
					.verifyComplete();
		}

	//========================================================================================

		// TODO Expect 3600 elements at intervals of 1 second, and verify quicker than 3600s
		// by manipulating virtual time thanks to StepVerifier#withVirtualTime, notice how long the test takes
		void expect3600Elements(Supplier<Flux<Long>> supplier) {
/*			StepVerifier.withVirtualTime(supplier)
					.thenAwait(Duration.ofSeconds(3600))
					.expectNextCount(3600)
					.verifyComplete();*/
			StepVerifier.withVirtualTime(supplier)
	        .expectSubscription()
            .expectNoEvent(Duration.ofSeconds(1))
			.thenAwait(Duration.ofSeconds(3600))
			.expectNextCount(3600)
			.verifyComplete();
		}

		private void fail() {
			throw new AssertionError("workshop not implemented");
		}

}
