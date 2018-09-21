package me.won.item05.usecase2;

import java.util.List;

/* item03 의 방법을 사용하였으나 독립적인 Util 클래스가 아님
 * 마찬가지로 KoreanDictionary 고정이라는 문제있음
 * */
public class SpellChecker {
	private final Lexicon dictionary = new KoreanDictionary();
	private SpellChecker() {
	}
	
	public static final SpellChecker INSTANCE = new SpellChecker() {};
	
	public boolean isValid(String workd) {
		throw new UnsupportedOperationException();
	}
	
	public List<String> suggestions(String type){
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		SpellChecker.INSTANCE.isValid("hello");
	}
}

interface Lexicon{}

class KoreanDictionary implements Lexicon{}