package me.won.effectivejava3rd.item02;

import java.util.EnumSet;
import java.util.Objects;

//해결책3
public abstract class Pizza {
	public enum Topping {
        HAM, MUSHROOM, ONION, PEEPER, SAUSAGE
    }

    final EnumSet<Topping> toppings;

    abstract static class Builder<T extends  Builder<T>> { // `재귀적인 타입 매개변수`
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build(); // `Convariant 리턴 타입`을 위한 준비작업

        protected abstract T self(); // `self-type` 개념을 사용해서 메소드 체이닝이 가능케 함
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
