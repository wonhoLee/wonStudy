package me.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import me.spring.ChangePasswordService;
import me.spring.MemberDao;
import me.spring.MemberInfoPrinter;
import me.spring.MemberListPrinter;
import me.spring.MemberPrinter;
import me.spring.MemberRegisterService;
import me.spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages= {"me.spring"})
public class AppCtx {
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	@Bean
	@Qualifier("chgPwdSvc")
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberPrinter());
	}
//	@Bean
//	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
//		return infoPrinter;
//	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
