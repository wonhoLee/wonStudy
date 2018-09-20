package ch1.refact;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie _movie, int _daysRented) {
		super();
		this._movie = _movie;
		this._daysRented = _daysRented;
	}
	
	
	public Movie getMovie() {
		return _movie;
	}
	public int getDaysRented() {
		return _daysRented;
	}


	double getCharge() {
		double result = 0;
		//각 영화에 대한 요금 결정
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(getDaysRented() > 2)
				result += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += getDaysRented() * 3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if (getDaysRented() > 3)
				result += (getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}


	int getFrequentRenterPoints() {
		//최신(new realease)을 이틀 이상 대여하는 경우 추가포인트 제공
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			return 2;
		else
			return 1;
	}
	
	
}
