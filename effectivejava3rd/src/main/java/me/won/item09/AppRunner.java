package me.won.item09;

public class AppRunner {
	public static void main(String[] args) {
		/*MyResource myResource = new MyResource();
		try {
			myResource.doSomething();
		}finally {
			myResource.close();
		}*/
		
		try(MyResource myResourceR = new MyResource(); 
				MyResource myResource2 = new MyResource()){
			myResourceR.doSomething();
		}
	}
}
