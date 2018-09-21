package me.won.item05.usecase1;

import java.util.List;

/* item04 의 방법을 사용하였으나 독립적인 Util 클래스가 아님
 * 해당방법처럼 사용한다면 dictionary 가 KoreanDictionary으로 고정되버림
 * 만약 바꾸고 싶다면 소스수정...
 * */
public class SpellChecker {
	private static final Lexicon dictionary = new KoreanDictionary();
	private SpellChecker() {
		//Noninstantiable
	}
	
	public static boolean isValid(String workd) {
		throw new UnsupportedOperationException();
	}
	
	public static List<String> suggestions(String type){
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		SpellChecker.isValid("hello");
	}
}

interface Lexicon{}

class KoreanDictionary implements Lexicon{}