package me.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class ChangePasswordService {
	@Autowired(required=false)	//1. NULL 허용
	@Qualifier("chgPwdSvc")		//chgPwdSvc 로 등록
	@Nullable					//3. NULL허용
	private MemberDao memberDao;
	//private Optional<MemberDao> memberDao;	//2. NULL허용

//	public void setMemberDao(MemberDao memberDao) {
//	this.memberDao = memberDao;
//}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
