package me.won.effectivejava3rd.item02;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

//참고 롬복으로 사용해보기
//장점 : 간편하게 사용할수 있음
//단점 : 어떻게 구현되어있는지 알수가 없음 - 구현체가 보이지 않음
//      예제를 보고 잘 돌아가길 추측할수 밖에 없음
//		유지보수하기 별로로 보임 
@Builder
public class NutritionFactsLombok {
	@Builder.Default private int servingSize = 10;
	private int servings;
	private int calories;
	private int sodium;
	private int carbohydrate;
	@Singular private List<String> names;
	
	public static void main(String[] args) {
		NutritionFactsLombok nutritionFactsLombok = NutritionFactsLombok.builder()
				.servings(10)
				.name("testName")
				.name("testName2")
				.build();
	}
}
