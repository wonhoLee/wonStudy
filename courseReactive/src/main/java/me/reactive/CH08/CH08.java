package me.reactive.CH08;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CH08 {
	static class ReactiveRepository<T>{

		public Flux<User> findAll() {
			return null;
		}
		
	}
	
	static class ReactiveUserRepository extends ReactiveRepository{
		
	}
	
	static class User{
		public static final User SKYLER = null;
		public static final User JESSE = null;
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
	
	ReactiveRepository<User> repository = new ReactiveUserRepository();

	//========================================================================================

		// TODO Adapt Flux to RxJava Flowable
		Flowable<User> fromFluxToFlowable(Flux<User> flux) {
			return Flowable.fromPublisher(flux); 
		}

		// TODO Adapt RxJava Flowable to Flux
		Flux<User> fromFlowableToFlux(Flowable<User> flowable) {
			return Flux.from(flowable);
		}

	//========================================================================================

		// TODO Adapt Flux to RxJava Observable
		Observable<User> fromFluxToObservable(Flux<User> flux) {
			return Observable.fromPublisher(flux);
		}

		// TODO Adapt RxJava Observable to Flux
		Flux<User> fromObservableToFlux(Observable<User> observable) {
			return Flux.from(observable.toFlowable(BackpressureStrategy.BUFFER));
		}

	//========================================================================================

		// TODO Adapt Mono to RxJava Single
		Single<User> fromMonoToSingle(Mono<User> mono) {
			return Single.fromPublisher(mono);
		}

		// TODO Adapt RxJava Single to Mono
		Mono<User> fromSingleToMono(Single<User> single) {
			return Mono.from(single.toFlowable());
		}

	//========================================================================================

		// TODO Adapt Mono to Java 8+ CompletableFuture
		CompletableFuture<User> fromMonoToCompletableFuture(Mono<User> mono) {
			return mono.toFuture();
		}

		// TODO Adapt Java 8+ CompletableFuture to Mono
		Mono<User> fromCompletableFutureToMono(CompletableFuture<User> future) {
			return Mono.fromFuture(future);
		}
		
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");
			future.thenApply(s -> s.toUpperCase());
			future.get();
			
			Flux.just("hello")
				.map(s -> s.toUpperCase())
				.subscribe();
			
			
		}
}
