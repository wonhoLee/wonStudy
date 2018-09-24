package me.won.item08;

public class SampleRunner {
	public static void main(String[] args) {
		/*SampleRunner runner = new SampleRunner();
		runner.run();*/
		
		/*SampleResource sampleResource = null;
		try {
			sampleResource = new SampleResource();
			sampleResource.hello();
		} finally {
			if(sampleResource != null) {
				sampleResource.close();
			}
		}*/

		/* 권한하는 방법 try with resource
		 * try(SampleResource sampleResource = new SampleResource()) {
			sampleResource.hello();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		SampleRunner runner = new SampleRunner();
		runner.run();
		//System.gc();
		
		//try with resource 추가
		try(var sampleResource = new SampleResource()) {
			sampleResource.hello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void run() {
		/*FinalizerExample finalizerExample = new FinalizerExample();
		finalizerExample.hello();*/
		
		SampleResource sampleResource = new SampleResource();
		sampleResource.hello();
	}
}
