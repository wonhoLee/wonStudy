package me.won.item05.usecase4;

import java.util.List;

import org.springframework.stereotype.Component;

/* Spring 에서의 Case 설명
 * */
@Component
public class SpellChecker {
	private Lexicon lexicon;
	
	private SpellChecker(Lexicon lexicon) {
		this.lexicon = lexicon;
	}
	
	public boolean isValid(String word) {
		lexicon.print();
		return true;
	}
	
	public List<String> suggestions(String type){
		throw new UnsupportedOperationException();
	}
}