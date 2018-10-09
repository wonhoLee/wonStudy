package me.exam.ch11;

import java.math.BigDecimal;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MethodReferenceExamples3 {
	public static void main(String[] args) {
		//final Product product = new Product(1L, "A", new BigDecimal("100"));
		
		final Section section = new Section(1);
		
		final Function<Integer, Section> sectionFactory = number -> new Section(number);
		final Section section1WithLambdaExpression = sectionFactory.apply(1);
		
		final Function<Integer, Section> sectionFactoryWithMethodReference = Section::new;
		final Section section1WithMethodReference = sectionFactoryWithMethodReference.apply(1);
		
		System.out.println(section);
		System.out.println(section1WithLambdaExpression);
		System.out.println(section1WithMethodReference);
		
		final OldProduct product = new OldProduct(1L, "A", new BigDecimal("100"));
		System.out.println(product);
		
		final OldProductCreator productCareator = OldProduct::new;
		System.out.println(productCareator.create(1L, "A", new BigDecimal("100")));
		
		final ProductA a = createProduct(1L, "A", new BigDecimal("123"), ProductA::new);
		final ProductB b = createProduct(2L, "B", new BigDecimal("123"), ProductB::new);
		
		System.out.println(a);
		System.out.println(b);
	}
	
	private static <T extends Product> T createProduct(final Long id, final String name, final BigDecimal price, final ProductCreator<T> productCreator) {
		if(id == null || id < 1L) {
			throw new IllegalArgumentException("The id must be a positive Long.");
		}
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("The name is not given.");
		}
		if(price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("The price is not given.");
		}
		return productCreator.create(id, name, price);
	}
}

@FunctionalInterface
interface ProductCreator<T extends Product>{
	T create(Long id, String name, BigDecimal price);
}

@FunctionalInterface
interface OldProductCreator<T extends OldProduct>{
	T create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section{
	private int number;
}

@AllArgsConstructor
@Data
class OldProduct{
	private Long id;
	private String name;
	private BigDecimal price;
}

@AllArgsConstructor
@Data
abstract class Product{
	private Long id;
	private String name;
	private BigDecimal price;
}

class ProductA extends Product{

	public ProductA(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return "A=" + super.toString();
	}
	
	
}

class ProductB extends Product{

	public ProductB(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return "B=" + super.toString();
	}
	
	
}