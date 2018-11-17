package me.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import me.spring.MemberDao;
import me.spring.MemberPrinter;

@Configuration
@Import(AppCtx2.class)
public class AppCtx1 {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
