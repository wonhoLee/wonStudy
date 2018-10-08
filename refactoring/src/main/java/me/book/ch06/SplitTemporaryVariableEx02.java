package me.book.ch06;

public class SplitTemporaryVariableEx02 {
	int _primaryForce;
	int _mass;
	int _delay;
	int _secondaryForce;
	
	/*origin
	 * double getDistanceTravelled(int time) {
		double result;
		double acc = _primaryForce / _mass;
		int primaryTime = Math.min(time,  _delay);
		result = 0.5 * acc * primaryTime * primaryTime;
		int secondaryTime = time - _delay;
		if(secondaryTime > 0) {
			double primaryVel = acc * _delay;
			acc = (_primaryForce * _secondaryForce) / _mass;
			result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
		}
		return result;
	}*/
	
	double getDistanceTravelled(int time) {
		double result;
		final double primaryAcc = _primaryForce / _mass;
		int primaryTime = Math.min(time,  _delay);
		result = 0.5 * primaryAcc * primaryTime * primaryTime;
		int secondaryTime = time - _delay;
		if(secondaryTime > 0) {
			double primaryVel = primaryAcc * _delay;
			final double secondaryAcc = (_primaryForce * _secondaryForce) / _mass;
			result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
		}
		return result;
	}
}
