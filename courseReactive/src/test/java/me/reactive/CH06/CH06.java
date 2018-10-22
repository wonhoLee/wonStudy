package me.reactive.CH06;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CH06 {
	static class ReactiveRepository<T>{

		public Flux<User> findAll() {
			// TODO Auto-generated method stub
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

		// TODO Create a StepVerifier that initially requests all values and expect 4 values to be received
		StepVerifier requestAllExpectFour(Flux<User> flux) {
			return StepVerifier.create(flux)
						.expectNextCount(4)
						.expectComplete();
		}

	//========================================================================================

		// TODO Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE.
		StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
			return StepVerifier.create(flux, 1)
						.expectNext(User.SKYLER)
						.thenRequest(1)
						.expectNext(User.JESSE)
						.thenCancel();
		}

	//========================================================================================

		// TODO Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
		Flux<User> fluxWithLog() {
			return repository.findAll().log();
		}

	//========================================================================================

		// TODO Return a Flux with all users stored in the repository that prints "Starring:" on subscribe, "firstname lastname" for all values and "The end!" on complete
		Flux<User> fluxWithDoOnPrintln() {
			return repository.findAll()
					.doOnSubscribe(s -> System.out.println("Starring:"))
					.doOnNext(u -> System.out.println(u.getFirstname() + " " + u.getLastname()))
					.doOnComplete(() -> System.out.println("The end!"))
					;
		}

}

