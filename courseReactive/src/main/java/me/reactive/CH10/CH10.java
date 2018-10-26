package me.reactive.CH10;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class CH10 {

	static class User{
		private String username;

		public User(String username) {
			super();
			this.username = username;
		}

		@Override
		public String toString() {
			return "User [username=" + username + "]";
		}
		
		
		
	}
	
	static class UserRepository{
		public List<User> findAll(){
			return List.of(new User("test"), new User("won"));
		}
	}
	
//========================================================================================

	// TODO Return the user contained in that Mono
	User monoToValue(Mono<User> mono) {
		return mono.block();
	}

//========================================================================================

	// TODO Return the users contained in that Flux
	Iterable<User> fluxToValues(Flux<User> flux) {
		return null;
	}

	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();
		Flux.defer(() -> Flux.fromIterable(userRepository.findAll()))
				.subscribeOn(Schedulers.elastic());
				
	}
	
}
