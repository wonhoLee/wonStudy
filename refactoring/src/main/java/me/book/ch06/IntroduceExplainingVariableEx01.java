package me.book.ch06;

public class IntroduceExplainingVariableEx01 {
	private boolean wasInitialized() {
		return true;
	}
	
	/*origin
	 * void example(String platform, String browser, int resized) {
		if((platform.toUpperCase().indexOf("MAX") > -1) && (browser.toUpperCase().indexOf("IE") > -1) && wasInitialized() && resized > 0) {
			//doSomeThing
		}
	}*/
	
	void example(String platform, String browser, int resized) {
		final boolean isMacOS = platform.toUpperCase().indexOf("MAX") > -1;
		final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
		final boolean wasResized = resized > 0;
		
		if(isMacOS && isIEBrowser && wasInitialized() && wasResized) {
			//doSomeThing
		}
	}
}
