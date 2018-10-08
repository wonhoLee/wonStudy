package me.book.ch06;

public class RemoveAssignmentsToParametersEx01 {
	/* origin
	 * int discount(int inputVal, int quantity, int yearToDate) {
		if (inputVal > 50)
			inputVal -= 2;
		
		return inputVal;
	}*/

	int discount(int inputVal, int quantity, int yearToDate) {
		int result = inputVal;
		if (inputVal > 50)
			result -= 2;
		
		return result;
	}
}
