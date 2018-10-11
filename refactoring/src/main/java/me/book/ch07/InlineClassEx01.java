package me.book.ch07;

/*
 * orign

public class InlineClassEx01 {
	private String _name;
	private InlineClassEx01TelephoneNumber _officeTelephone = new InlineClassEx01TelephoneNumber();
	
	public String get_name() {
		return _name;
	}
	public String get_officeAreaCode() {
		return _officeTelephone.get_areaCode();
	}
	public void set_officeAreaCode(String _officeAreaCode) {
		_officeTelephone.set_areaCode(_officeAreaCode);
	}
	public String getTelephoneNumber() {
		return _officeTelephone.getTelephoneNumber();
	}
	InlineClassEx01TelephoneNumber getOfficeTelephone() {
		return _officeTelephone;
	}
}

class InlineClassEx01TelephoneNumber{
	private String _areaCode;
	private String _number;

	public String get_areaCode() {
		return _areaCode;
	}

	public void set_areaCode(String _areaCode) {
		this._areaCode = _areaCode;
	}
	
	public String get_number() {
		return _number;
	}

	public void set_number(String _number) {
		this._number = _number;
	}

	public String getTelephoneNumber() {
		return ("(" + _areaCode + ") " + _number);
	}
	
}
 */

public class InlineClassEx01 {
	private String _name;
	private String _areaCode;
	private String _number;
	
	public String get_name() {
		return _name;
	}
	public String get_areaCode() {
		return _areaCode;
	}
	public void set_areaCode(String _areaCode) {
		this._areaCode = _areaCode;
	}
	public String get_number() {
		return _number;
	}
	public void set_number(String _number) {
		this._number = _number;
	}
	
	public String getTelephoneNumber() {
		return ("(" + _areaCode + ") " + _number);
	}
}