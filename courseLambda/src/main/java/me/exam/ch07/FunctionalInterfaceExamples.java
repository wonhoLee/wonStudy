package me.exam.ch07;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class FunctionalInterfaceExamples {
	public static void main(String[] args) {
		ProductLombok productA = new ProductLombok(1L, "A", new BigDecimal("10.00"));
		ProductLombok productB = new ProductLombok(2L, "B", new BigDecimal("55.00"));
		ProductLombok productC = new ProductLombok(3L, "C", new BigDecimal("17.00"));
		ProductLombok productD = new ProductLombok(4L, "D", new BigDecimal("23.00"));
		ProductLombok productE = new ProductLombok(5L, "E", new BigDecimal("110.00"));
		final List<ProductLombok> products = Arrays.asList(
				productA,
				productB,
				productC,
				productD,
				productE
				);
		
		System.out.println(products);
		
		final BigDecimal twenty = new BigDecimal("20");
		System.out.println(filter(products, product -> product.getPrice().compareTo(twenty) >= 0));
		System.out.println(filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));
		
		final List<ProductLombok> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
		
		/*final List<DicountedProduct> discountedProducts = new ArrayList<>();
		for(final ProductLombok product : expensiveProducts) {
			discountedProducts.add(new DicountedProduct(product.getId(), product.getName(), product.getPrice()));
		}*/
		
		final List<DicountedProduct> discountedProducts = map(expensiveProducts, product -> new DicountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
		
		System.out.println(expensiveProducts);
		System.out.println(discountedProducts);
		
		Predicate<ProductLombok> lessThanOrEqualTo30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
		System.out.println("discounted product (<=$30) " + filter(discountedProducts, lessThanOrEqualTo30));
		System.out.println("discounted product (<=$30) " + filter(products, lessThanOrEqualTo30));
		
		/*final List<BigDecimal> prices = map(products, product -> product.getPrice());
		BigDecimal total = BigDecimal.ZERO;
		for(final BigDecimal price : prices) {
			total = total.add(price);
		}
		System.out.println(total);*/
		
		final BigDecimal newTotal = total(products, product -> product.getPrice());
		System.out.println(newTotal);
		
		final BigDecimal discountedTotal = total(discountedProducts, product -> product.getPrice());
		System.out.println(discountedTotal);
		
		Order order = new Order(1L, "on-1234", Arrays.asList(
				new OrderedItem(1L, productA, 2),
				new OrderedItem(2L, productC, 1),
				new OrderedItem(3L, productD, 10)
				));
		
		System.out.println(order.totalPrice());
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate){
		final List<T> result = new ArrayList<>();
		for (final T t : list) {
			if(predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	private static <T, R> List<R> map(List<T> list, Function<T, R> function){
		final List<R> r = new ArrayList<>();
		for(final T t : list) {
			r.add(function.apply(t));
		}
		return r;
	}
	
	private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
		BigDecimal total = BigDecimal.ZERO;
		for(final T t : list) {
			total = total.add(mapper.apply(t));
		}
		return total;
	}
	
	@ToString(callSuper = true)
	static class DicountedProduct extends ProductLombok{

		public DicountedProduct(Long id, String name, BigDecimal price) {
			super(id, name, price);
		}
		
	}

	@AllArgsConstructor
	@Data
	static class OrderedItem{
		private Long id;
		private ProductLombok product;
		private int quantity;
		
		public BigDecimal getItemTotal() {
			return product.getPrice().multiply(new BigDecimal(quantity));
		}
	}

	@AllArgsConstructor
	@Data
	static class Order{
		private Long id;
		private String orderNumber;
		private List<OrderedItem> items;
		
		public BigDecimal totalPrice() {
			return total(items, item -> item.getItemTotal());
		}
	}
}



