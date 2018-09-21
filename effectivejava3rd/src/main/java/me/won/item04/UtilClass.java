package me.won.item04;

//책의 가이드대로면 private 을 권고하지만
//현실적으로 abstract class 로 만들어만 줘도 충분할듯함

/* 책에나온 가이드
 * public class UtilClass {
	//유틸 클래스라 인스턴스를 만들지 못하게 막았습니다.
	private UtilClass() {
		throw new AssertionError();
	}
	
	public static String getName() {
		return "won";
	}
}*/

//충분한 방법 (spring 에서도 해당방법 사용중)
public abstract class UtilClass {
	public static String getName() {
		return "won";
	}
}