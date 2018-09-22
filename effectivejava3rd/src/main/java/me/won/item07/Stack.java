package me.won.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

//Can you spot the "memory leak"?
public class Stack {
	
	private Object[] elements;
	
	private int size = 0;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		this.ensureCapacity();
		this.elements[size++] = e;
	}
	
	/* 잘못된 예
	 * public Object pop() {
		if(size ==0) {
			throw new EmptyStackException();
		}
		
		return this.elements[--size];
	}*/
	
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		Object value = this.elements[--size];
		this.elements[size] = null;
		return value;
	}
	
	
	/**
     * Ensure space for at least one more element,
     * roughly doubling the capacity each time the array needs to grow.
     */
	private void ensureCapacity() {
		if(this.elements.length == size) {
			this.elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
