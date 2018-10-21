package me.reactive.CH04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH04 {
	public static class User {
		private String username;
		private String firstname;
		private String lastname;

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

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		return mono.map(s -> new User(s.getUsername().toUpperCase(), s.getFirstname().toUpperCase(), s.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(s -> new User(s.getUsername().toUpperCase(), s.getFirstname().toUpperCase(), s.getLastname().toUpperCase()));
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return flux.flatMap(s -> Flux.just(new User(s.getUsername().toUpperCase(), s.getFirstname().toUpperCase(), s.getLastname().toUpperCase())));
	}

	Mono<User> asyncCapitalizeUser(User u) {
		return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

}
