package main.service;

import main.ch5.Member;
import main.ch5.Team;

public class Ch5Service {
    public void ch5run(){
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team1 = new Team("team1", "팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        Team findTeam = member1.getTeam();
    }
}
