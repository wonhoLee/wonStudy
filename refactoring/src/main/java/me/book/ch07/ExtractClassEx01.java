package me.book.ch07;

/* origin
 * public class ExtractClassEx01 {
	private String _name;
	private String _officeAreaCode;
	private String _officeNumber;
	
	public String get_name() {
		return _name;
	}
	public String getTelephoneNumber() {
		return ("(" + _officeAreaCode + ") " + _officeNumber);
	}
	public String get_officeAreaCode() {
		return _officeAreaCode;
	}
	public void set_officeAreaCode(String _officeAreaCode) {
		this._officeAreaCode = _officeAreaCode;
	}
	public String get_officeNumber() {
		return _officeNumber;
	}
	public void set_officeNumber(String _officeNumber) {
		this._officeNumber = _officeNumber;
	}
}*/

public class ExtractClassEx01 {
	private String _name;
	private ExtractClassEx01TelephoneNumber _officeTelephone = new ExtractClassEx01TelephoneNumber();
	
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
	ExtractClassEx01TelephoneNumber getOfficeTelephone() {
		return _officeTelephone;
	}
}

class ExtractClassEx01TelephoneNumber{
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