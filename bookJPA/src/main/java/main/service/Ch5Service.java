package main.service;

import main.ch5.MemberCh5;
import main.ch5.MemberCh5Repository;
import main.ch5.Team;
import main.ch5.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ch5Service {
    private final MemberCh5Repository memberCh5Repository;
    private final TeamRepository teamRepository;

    public Ch5Service(MemberCh5Repository memberCh5Repository, TeamRepository teamRepository) {
        this.memberCh5Repository = memberCh5Repository;
        this.teamRepository = teamRepository;
    }

    public void ch5run(){
        MemberCh5 memberCh51 = new MemberCh5("member1", "회원1");
        MemberCh5 memberCh52 = new MemberCh5("member2", "회원2");
        Team team1 = new Team("team1", "팀1");

        memberCh51.setTeam(team1);
        memberCh52.setTeam(team1);

        Team findTeam = memberCh51.getTeam();
    }

    public void testSave(){
        Team team1 = new Team("team1", "팀1");
        teamRepository.save(team1);

        MemberCh5 memberCh5 = new MemberCh5("member1", "회원1");
        memberCh5.setTeam(team1);
        memberCh5Repository.save(memberCh5);

        MemberCh5 memberCh52 = new MemberCh5("member2", "회원2");
        memberCh52.setTeam(team1);
        memberCh5Repository.save(memberCh52);

        List<MemberCh5> memberList = memberCh5Repository.findAll();
        for (MemberCh5 m: memberList) {
            System.out.println("ID : " + m.getId() + " UserName : " + m.getUsername());
        }
        List<Team> teamList = teamRepository.findAll();
        for (Team t:teamList) {
            List<MemberCh5> members = t.getMemberCh5List();
            for (MemberCh5 m:members) {
                System.out.println("Team Member Id : " + m.getId() + " UserName : " + m.getUsername());
            }
            System.out.println("Team Id : " + t.getId() + " Team Name : " + t.getName());
        }

        List<MemberCh5> memberCh5List = memberCh5Repository.findByTeamName("팀1");
        for (MemberCh5 m: memberCh5List) {
            System.out.println("S2 ID : " + m.getId() + " UserName : " + m.getUsername());
        }

        Team team2 = new Team("team2", "팀2");
        teamRepository.save(team2);
    }

}
