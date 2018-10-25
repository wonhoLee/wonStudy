package me.reactive.CH09;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH09 {
	static class User{
		public static final User SKYLER = null;
		private String username;
		private String firstname;
		private String lastname;
		public User(String username, String firstname, String lastname) {
			super();
			this.username = username;
			this.firstname = firstname;
			this.lastname = lastname;
		}
	}
//========================================================================================

	// TODO Create a Flux of user from Flux of username, firstname and lastname.
	Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
		return Flux.zip(usernameFlux, firstnameFlux, lastnameFlux)
					.map(t -> new User(t.getT1(), t.getT2(), t.getT3()));
	}

//========================================================================================

	// TODO Return the mono which returns its value faster
	Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
		return Mono.first(mono1, mono2);
	}

//========================================================================================

	// TODO Return the flux which returns the first value faster
	Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
		//return Flux.firstEmitting(flux1, flux2);
		return null;
	}

//========================================================================================

	// TODO Convert the input Flux<User> to a Mono<Void> that represents the complete signal of the flux
	Mono<Void> fluxCompletion(Flux<User> flux) {
		return Mono.ignoreElements(flux.then());
	}

//========================================================================================

	// TODO Return a valid Mono of user for null input and non null input user (hint: Reactive Streams do not accept null values)
	Mono<User> nullAwareUserToMono(User user) {
		return Mono.justOrEmpty(user);
	}

//========================================================================================

	// TODO Return the same mono passed as input parameter, expect that it will emit User.SKYLER when empty
	Mono<User> emptyToSkyler(Mono<User> mono) {
		return mono.defaultIfEmpty(User.SKYLER);
	}
	
	public static void main(String[] args) {
		var f1 = Flux.range(0,  10);
		var f2 = Flux.range(11,  20);
		var f3 = Flux.range(21,  30);
		
		//Flux.zip(f1, f2, (a, b) -> a + b);
		Flux.zip(f1, f2, f3)
			.map(t -> t.getT1() + t.getT2() + t.getT3())
			.log()
			.blockLast();
		
//		Flux.zip(f1, f2)
//			.map(t -> t.getT1() + t.getT2())
//			.log()
//			.blockLast();
		
	}

}
