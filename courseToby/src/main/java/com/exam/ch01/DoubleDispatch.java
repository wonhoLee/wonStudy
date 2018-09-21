package com.exam.ch01;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {
	interface Post { 
		void postOn(SNS sns); 
	}
	static class Text implements Post{
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}
	static class Picture implements Post{
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}
	
	interface SNS {
		void post(Text post);
		void post(Picture post);
	}
	static class Facebook implements SNS{
		@Override
		public void post(Text post) {
			System.out.println("text-facebook");
		}

		@Override
		public void post(Picture post) {
			System.out.println("picture-facebook");
		}
	};
	static class Twitter implements SNS{
		@Override
		public void post(Text post) {
			System.out.println("text-Twitter");
		}

		@Override
		public void post(Picture post) {
			System.out.println("picture-Twitter");
		}
	};
	static class GooglePlus implements SNS{
		@Override
		public void post(Text post) {
			System.out.println("text-GooglePlus");
		}

		@Override
		public void post(Picture post) {
			System.out.println("picture-GooglePlus");
		}
	};
	
	public static void main(String[] args) {
		List<Post> posts = Arrays.asList(new Text(), new Picture());
		List<SNS> sns = Arrays.asList(new Facebook(), new Twitter(), new GooglePlus());
		
		/*for(Post p : posts) {
			for(SNS s : sns) {
				p.postOn(s);
			}
		}*/
		posts.forEach(p -> sns.forEach(s -> p.postOn(s)));

	}
}
