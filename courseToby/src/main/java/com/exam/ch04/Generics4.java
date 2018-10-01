package com.exam.ch04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//상속
public class Generics4 {
	static class MyList<E, P> implements List<E>{

		@Override
		public boolean add(E arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void add(int arg0, E arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean addAll(Collection<? extends E> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int arg0, Collection<? extends E> arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E get(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E remove(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E set(int arg0, E arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<E> subList(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		/* Integer 와 Numer 의 관계 : subClass 관계
		 * List<Integer> 와 List<Number> 와의 관계 : subClass 아님
		 * ArrayList<Integer> 와 List<Integer> 와의 관계 : 가능
		Integer i = 10;
		Number n = i;
		
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		List<Number> numberList = intList;
		
		ArrayList<Integer> arrList = new ArrayList<>();
		List<Integer> intList2 = arrList;*/
		
		List<String> s1 = new MyList<String, Integer>();
		List<String> s2 = new MyList<String, String>();
	}
}
