package me.reactive.CH06;

import java.time.Duration;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CH06Add2 {
	@Test
	public void reactorStudy() {
		Flux.range(1,  100)
			.log()
			.doOnNext(System.out::println)
			.subscribe(new Subscriber<Integer>() {
				private Subscription subscription;
				private int count;
				
				@Override
				public void onSubscribe(Subscription s) {
					this.subscription = s;
					this.subscription.request(10);
				}

				@Override
				public void onNext(Integer t) {
					count++;
					if(count % 10 == 0) {
						this.subscription.request(10);
					}
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}
			});
	}
}
