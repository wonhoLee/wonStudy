package me.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberPrinter printer) {
		//this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(member -> printer.print(member));
	}
}
