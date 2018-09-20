package ch1.refact;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();
	
	public Customer(String _name) {
		super();
		this._name = _name;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}
	
	public String statement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			
			//이 대여에 대한 요금 계산결과 표시
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		//풋터(footer) 추가
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
	
	public String htmlStatement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while (rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			//이 대여에 대한 요금 계산결과 표시
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}
		//풋터(footer) 추가
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points";
		return result;
	}
	
	public double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	public int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
}
