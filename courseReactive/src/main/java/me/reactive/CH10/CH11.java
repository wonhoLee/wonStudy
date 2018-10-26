package me.reactive.CH10;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH11 {

	static class User{
		
	}
	
	static class BlockingRepository<T>{
		
	}
	
//========================================================================================

	// TODO Create a Flux for reading all users from the blocking repository deferred until the flux is subscribed, and run it with an elastic scheduler
	Flux<User> blockingRepositoryToFlux(BlockingRepository<User> repository) {
		return null;
	}

//========================================================================================

	// TODO Insert users contained in the Flux parameter in the blocking repository using an elastic scheduler and return a Mono<Void> that signal the end of the operation
	Mono<Void> fluxToBlockingRepository(Flux<User> flux, BlockingRepository<User> repository) {
		return null;
	}

}
