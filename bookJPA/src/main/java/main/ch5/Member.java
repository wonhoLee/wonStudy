package main.ch5;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Team getTeam() {
        return team;
    }
}
