package me.won.item05.usecase4;

import org.springframework.stereotype.Component;

@Component
public class KoreanDictionary implements Lexicon{
	@Override
	public void print() {
		System.out.println("korean");
	}
}
