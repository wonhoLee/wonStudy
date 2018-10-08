package me.book.ch06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RemoveAssignmentsToParametersEx02 {
	public static void main(String[] args) {
		int x = 5;
		triple(x);
		System.out.println("X after triple : " + x);
		
		
		LocalDate d1 = LocalDate.parse("1998-04-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		nextDateUpdate(d1);
		System.out.println("d1 after nextDay : " + d1);
		
		LocalDate d2 = LocalDate.parse("1998-04-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		nextDateReplace(d2);
		System.out.println("d2 after nextDay : " + d2);
	}
	
	private static void triple(int arg) {
		arg = arg * 3;
		System.out.println("arg in triple : " + arg);
	}
	
	private static void nextDateUpdate(LocalDate arg) {
		arg = arg.plusDays(1);
		System.out.println("arg in nextDay : " + arg);
	}
	
	private static void nextDateReplace(LocalDate arg) {
		arg = LocalDate.parse(arg.plusDays(1).toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("arg in nextDay : " + arg);
	}
}
