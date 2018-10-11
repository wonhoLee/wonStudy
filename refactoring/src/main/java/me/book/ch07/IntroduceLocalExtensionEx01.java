package me.book.ch07;

import java.util.Date;

/* origin
 * public class IntroduceLocalExtensionEx01 extends Date{
	private Date original;
	
	public void nextDay() {
		
	}
	public void dayOfYear() {
		
	}
}*/

public class IntroduceLocalExtensionEx01{
	
}

//서브클래스를 사용하는 경우
class MfDate extends Date{
	private Date original;
	
	public MfDate(Date original) {
		this.original = original;
	}
	
	public Date nextDay() {
		return new Date (getYear(), getMonth(), getDate() + 1);
	}
	public void dayOfYear() {
		
	}
}

class MfDateSub extends Date{
	public MfDateSub(String dateSTring) {
		super(dateSTring);
	};
	
	public MfDateSub (Date arg) {
		super(arg.getTime());
	}
}

class client{
	private static Date nextDay(Date arg) {
		return new MfDate(arg).nextDay();
	}
}

//래퍼 클래스를 사용하는 경우
class MfDateWrap extends Date{
	private Date original;
	
	public MfDateWrap(String dateString) {
		this.original = new Date(dateString);
	}
	
	public MfDateWrap(Date arg) {
		this.original = arg;
	}
	
	public int getYear() {
		return this.original.getYear();
	}
	
	public boolean equals (MfDateWrap arg) {
		return (toDate().equals(arg.toDate()));
	}

	private Object toDate() {
		// TODO Auto-generated method stub
		return null;
	}
}