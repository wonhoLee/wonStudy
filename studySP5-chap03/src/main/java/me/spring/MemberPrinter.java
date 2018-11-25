package me.spring;

public class MemberPrinter {
	public void print(Member member) {
		System.out.println("회원정보 : 아이디=" + member.getId() + 
				", 이메일= " + member.getEmail() + 
				", 이름=" + member.getName() + 
				" , 등록일= " + member.getRegisterDateTime() + "\n"
				);
	}

}
