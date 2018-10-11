package me.book.ch07;

/* origin
 * public class RemoveMiddleManEx01 {
	RemoveMiddleManEx01Department department;
	
	public RemoveMiddleManEx01 getManager() {
		return this.department.getManager();
	}
}

class RemoveMiddleManEx01Department{
	private RemoveMiddleManEx01 manager;
	public RemoveMiddleManEx01Department(RemoveMiddleManEx01 manager) {
		this.manager = manager;
	}
	
	public RemoveMiddleManEx01 getManager() {
		return this.manager;
	}
}*/

public class RemoveMiddleManEx01 {
	RemoveMiddleManEx01Department department;
	
	public RemoveMiddleManEx01Department getDepartment() {
		return this.department;
	}
}

class RemoveMiddleManEx01Department{
	private RemoveMiddleManEx01 manager;
	public RemoveMiddleManEx01Department(RemoveMiddleManEx01 manager) {
		this.manager = manager;
	}
	
	public RemoveMiddleManEx01 getManager() {
		return this.manager;
	}
}