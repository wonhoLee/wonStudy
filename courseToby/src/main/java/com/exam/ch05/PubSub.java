package com.exam.ch05;

import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


/*
 * 구현하고자 하는 것
 * Publisher <- Observable
 * Subscriber <- Observer
 */
public class PubSub {
	public static void main(String[] args) {
		Iterable<Integer> iter = Arrays.asList(1,2,3,4,5);
		
		Publisher p = new Publisher() {
			@Override
			public void subscribe(Subscriber subscriber) {
				subscriber.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						
					}

					@Override
					public void cancel() {
						
					}
				});
			}
		};
		
		Subscriber<Integer> s = new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription subscription) {
				
			}

			@Override
			public void onNext(Integer item) {
				
			}

			@Override
			public void onError(Throwable throwable) {
				
			}

			@Override
			public void onComplete() {
				
			}
		};
		
		p.subscribe(s);
	}
}
