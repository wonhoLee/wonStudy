package me.won.item05.usecase3;

import java.util.List;
import java.util.Objects;

/* 의존성 주입으로 해당 케이스 해결 권고함
 * */
public class SpellChecker {
	private final Lexicon dictionary;
	
	private SpellChecker(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	
	public boolean isValid(String word) {
		throw new UnsupportedOperationException();
	}
	
	public List<String> suggestions(String type){
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		Lexicon lexicon = new KoreanDictionary();
		SpellChecker spellChecker = new SpellChecker(lexicon);
		spellChecker.isValid("hello");
	}
}

interface Lexicon{}

class KoreanDictionary implements Lexicon{}

class TestDictionary implements Lexicon{}	// 테스트 가능함