package me.book.ch06;

public class SplitTemporaryVariableEx01 {
	int _height;
	int _width;
	
	public SplitTemporaryVariableEx01(int _height, int _width) {
		super();
		this._height = _height;
		this._width = _width;
	}

	public static void main(String[] args) {
		SplitTemporaryVariableEx01 ex01 = new SplitTemporaryVariableEx01(10, 4);
	}
	
	/*origin
	 * void example(int width) {
		double temp = 2 * (_height + _width);
		System.out.println(temp);
		temp = _height * width;
		System.out.println(temp);
	}*/
	
	void example(int width) {
		final double perimeter = 2 * (_height + _width);
		System.out.println(perimeter);
		final double area = _height * width;
		System.out.println(area);
	}
}
