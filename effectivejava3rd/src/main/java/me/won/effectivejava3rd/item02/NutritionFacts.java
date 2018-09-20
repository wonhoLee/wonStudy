package me.won.effectivejava3rd.item02;

public class NutritionFacts {
	private int servingSize;
	private int servings;
	private int calories;
	private int sodium;
	private int carbohydrate;
	
	//해결책1
	public NutritionFacts(int servingSize, int servings, int calories, int sodium, int carbohydrate) {
		super();
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
	
	//해결책2
	public NutritionFacts() {
		
	}
	
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100, 35, 27);	//해결책1
		
		//해결책2
		NutritionFacts cocaCola = new NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
		
		
		
	}

}
