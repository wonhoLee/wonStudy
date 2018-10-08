package me.exam.ch08;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamExamples5Parallel {
	public static void main(String[] args) {
		final int[] sum = {0};
		IntStream.range(0, 100)
			.forEach(i -> sum[0] += i);
		System.out.println("                              sum : " + sum[0]);
		
		final int[] sum2 = {0};
		IntStream.range(0, 100)
			.parallel()
			.forEach(i -> sum2[0] += i);
		System.out.println("parallel sum(With side-effect)    : " + sum2[0]);
		
		System.out.println("Stream sum(no side-effect)        : " + 
				IntStream.range(0, 100)
					.sum());
		
		System.out.println("Parallel sum(Without side-effect) : " + 
				IntStream.range(0, 100)
					.parallel()
					.sum());
		
		/*final long start = System.currentTimeMillis();
		Arrays.asList(1,2,3,4,5,6,7,8)
			.stream()
			.map(i-> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.forEach(i -> System.out.println(i));
		System.out.println("Time : " + (System.currentTimeMillis() - start));*/
		
		final long start2 = System.currentTimeMillis();
		Arrays.asList(1,2,3,4,5,6,7,8)
			.parallelStream()
			.map(i-> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.forEach(i -> System.out.println(i));
		System.out.println("Time : " + (System.currentTimeMillis() - start2));
		
		final long start3 = System.currentTimeMillis();
		Arrays.asList(1,2,3,4,5,6,7,8)
			.parallelStream()
			.map(i-> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.forEach(i -> System.out.println(i));
		System.out.println("Time : " + (System.currentTimeMillis() - start3));
		
		//System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");	//코어수조절
		final long start4 = System.currentTimeMillis();
		Arrays.asList(1,2,3,4,5,6,7,8)
			.parallelStream()
			.map(i-> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.forEach(i -> System.out.println(i));
		System.out.println("Time : " + (System.currentTimeMillis() - start4));
	}
}
