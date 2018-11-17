package me.assembler;

import me.spring.ChangePasswordService;
import me.spring.MemberDao;
import me.spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao);
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberRegisterService getRegSvc() {
		return regSvc;
	}
	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
}
