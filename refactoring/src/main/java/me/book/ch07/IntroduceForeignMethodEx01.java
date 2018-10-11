package me.book.ch07;

import java.util.Date;

public class IntroduceForeignMethodEx01 {
	/* origin
	 * Date previousEnd;
	@SuppressWarnings("deprecation")
	Date newStart = new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);*/
	
	Date previousEnd;
	@SuppressWarnings("deprecation")
	Date newStart = nextDay(previousEnd);
	
	private static Date nextDay(Date arg) {
		//외래 메소드(foreign method), Date에 있어야
		return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
	}
}
