package me.book.ch07;

/*origin
 * public class HideDelegateEx01 {
	HideDelegateEx01Department department;

	public HideDelegateEx01Department getDepartment() {
		return department;
	}

	public void setDepartment(HideDelegateEx01Department department) {
		this.department = department;
	}
	
}

class HideDelegateEx01Department{
	private String chargeCode;
	private HideDelegateEx01 manager;
	
	public HideDelegateEx01Department (HideDelegateEx01 manager) {
		this.manager = manager;
	}
	
	public HideDelegateEx01 getManager() {
		return this.manager;
	}
}*/

public class HideDelegateEx01 {
	HideDelegateEx01Department department;

	public void setDepartment(HideDelegateEx01Department department) {
		this.department = department;
	}
	
	public HideDelegateEx01 getmanager() {
		return this.department.getManager();
	}
	
}

class HideDelegateEx01Department{
	private String chargeCode;
	private HideDelegateEx01 manager;
	
	public HideDelegateEx01Department (HideDelegateEx01 manager) {
		this.manager = manager;
	}
	
	public HideDelegateEx01 getManager() {
		return this.manager;
	}
}