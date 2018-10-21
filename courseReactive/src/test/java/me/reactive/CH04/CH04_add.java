package me.reactive.CH04;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.springframework.cglib.util.ParallelSorter;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class CH04_add {
	public static void main(String[] args) {
		CH04_add test = new CH04_add();
		test.contest();
	}
	
	@Test
	public void contest() {
		IntStream.range(0,10).parallel();
		
		Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
			.window(3)
			//.flatMap(l -> l.map(this::toUpperCase))											// 속도가 느림
			//.flatMap(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))		// 속도는 개선됐으나 순서대로 안나옴
			//.concatMap(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))		// 순서대로 나오지만 속도가 떨어짐(병렬이 의미없어짐)
			.flatMapSequential(l -> l.map(this::toUpperCase).subscribeOn(Schedulers.parallel()))	//병렬 처리 와 순서대로
			.doOnNext(System.out::println)
			.blockLast();
	}
	
	private List<String> toUpperCase(String s){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return List.of(s.toUpperCase(), Thread.currentThread().getName());
	}
}
