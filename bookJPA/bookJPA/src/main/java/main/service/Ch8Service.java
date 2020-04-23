package main.service;

import main.member.Member;
import main.member.MemberRepository;

public class Ch8Service {
    final MemberRepository memberRepository;

    public Ch8Service(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void selectStudy(){
        Member member = memberRepository.getOne(0);

    }
}
