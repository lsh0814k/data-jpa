package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@ToString(of = {"id", "username", "age"})
@NamedQuery(
        name="Member.findByUsername",
        query="select m from Member m where m.username = :username"
)
@NamedEntityGraph(
        name="Member.all",
        attributeNodes = @NamedAttributeNode("team")
)
public class Member extends BaseEntity {

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

    public void changeUsername(String username) {
        this.username = username;
    }
}
