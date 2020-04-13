package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.member.Member;
import main.member.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void find() {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("지한");
		member.setAge(2);

		// 등록
		memberRepository.save(member);

		// 수정
		member.setAge(20);
		memberRepository.save(member);
		
		// 한건 조회
		Member findMember = memberRepository.findById(id);
		System.out.println("findMember : " + findMember.getUsername() + " Age : " + findMember.getAge());

		// 목록 조회
		List<Member> members = memberRepository.findAll();
		System.out.println("members.size : " + members.size());

		
//		memberRepository.delete(member);
//		memberRepository.deleteAll();
	}
}
