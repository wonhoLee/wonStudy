package me.won.item05.usecase3;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* 의존성 주입으로 해당 케이스 해결 권고함
 * Supplier 사용 케이스
 * */
public class SpellChecker2 {
	private final Lexicon2 dictionary;
	
	private SpellChecker2(Supplier<Lexicon2> dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary.get());
	}
	
	public boolean isValid(String word) {
		throw new UnsupportedOperationException();
	}
	
	public List<String> suggestions(String type){
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		Lexicon2 lexicon = new KoreanDictionary2();
		SpellChecker2 spellChecker = new SpellChecker2(() -> lexicon);
		spellChecker.isValid("hello");
	}
}

interface Lexicon2{}

class KoreanDictionary2 implements Lexicon2{}

class TestDictionary2 implements Lexicon2{}	// 테스트 가능함