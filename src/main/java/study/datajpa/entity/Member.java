package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@ToString(of = {"id", "username", "age"})
public class Member {

    // 기본 생성자는 필수
    protected Member() {}

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
