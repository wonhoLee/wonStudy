package me.reactive.CH07;

import java.io.IOException;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH07 {
	public static class User{
		private String username;
		private String firstname;
		private String lastname;
		public static final User SAUL = null;
		public static final User JESSE = null;
		
		public User(String username, String firstname, String lastname) {
			super();
			this.username = username;
			this.firstname = firstname;
			this.lastname = lastname;
		}
		public String getUsername() {
			return username;
		}
		public String getFirstname() {
			return firstname;
		}
		public String getLastname() {
			return lastname;
		}
	}
	//========================================================================================

		// TODO Return a Mono<User> containing User.SAUL when an error occurs in the input Mono, else do not change the input Mono.
		Mono<User> betterCallSaulForBogusMono(Mono<User> mono) {
			return mono.onErrorResume(e -> Mono.just(User.SAUL));
		}

	//========================================================================================

		// TODO Return a Flux<User> containing User.SAUL and User.JESSE when an error occurs in the input Flux, else do not change the input Flux.
		Flux<User> betterCallSaulAndJesseForBogusFlux(Flux<User> flux) {
			return flux.onErrorResume(e -> Flux.just(User.SAUL, User.JESSE));
		}

	//========================================================================================

		// TODO Implement a method that capitalizes each user of the incoming flux using the
		// #capitalizeUser method and emits an error containing a GetOutOfHereException error
		Flux<User> capitalizeMany(Flux<User> flux) {
			return flux.map(u -> {
				try {
					return capitalizeUser(u);
				}catch(GetOutOfHereException e) {
					throw Exceptions.propagate(e);
				}
			});
		}

		User capitalizeUser(User user) throws GetOutOfHereException {
			if (user.equals(User.SAUL)) {
				throw new GetOutOfHereException();
			}
			return new User(user.getUsername(), user.getFirstname(), user.getLastname());
		}

		protected final class GetOutOfHereException extends Exception {
		}

}
