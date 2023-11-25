package study.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {

    // 기본 생성자는 필수
    protected Member() {}

    public Member(String username) {
        this.username = username;
    }

    @Id @GeneratedValue
    private Long id;
    private String username;


}
