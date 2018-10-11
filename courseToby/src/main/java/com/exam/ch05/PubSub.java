package com.exam.ch05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


/*
 * 구현하고자 하는 것
 * Publisher <- Observable
 * Subscriber <- Observer
 */
public class PubSub {
	public static void main(String[] args) throws InterruptedException {
		Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		Publisher p = new Publisher() {
			@Override
			public void subscribe(Subscriber subscriber) {
				Iterator<Integer> it = itr.iterator();
				
				subscriber.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						//Future<?> f = es.submit(task)
						
						es.execute(() -> {
							int i = 0;
							try {
								while(i++ < n) {
									if(it.hasNext()) {
										subscriber.onNext(it.next());
									}else {
										subscriber.onComplete();
										break;
									}
								}
							}catch(RuntimeException e) {
								subscriber.onError(e);
							}
						});
					}

					@Override
					public void cancel() {
						System.out.println("cancel");
					}
				});
			}
		};
		
		Subscriber<Integer> s = new Subscriber<Integer>() {
			Subscription subscription;
			@Override
			public void onSubscribe(Subscription subscription) {
				System.out.println("onSubscribe");
				this.subscription = subscription;
				this.subscription.request(1);
			}

			@Override
			public void onNext(Integer item) {
				System.out.println(Thread.currentThread().getName() + " onNext : " + item);
				this.subscription.request(1);
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("onError : " + throwable.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		};
		
		p.subscribe(s);
		es.awaitTermination(10, TimeUnit.HOURS);
		es.shutdown();
	}
}
