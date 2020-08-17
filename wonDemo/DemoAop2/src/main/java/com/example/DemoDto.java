package com.example;

public class DemoDto {
	@MaskingFieldAnno
    private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
    
    
}
