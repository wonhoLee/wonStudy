package me.exam.ch07;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductLombok {
	private Long id;
	private String name;
	private BigDecimal price;
}
