package study.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    /**
     * 엔티티가 영속화되기 전에 실행이 된다.
     */
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    /**
     * 영속 상태의 엔티티를 이용하여 데이터 업데이트를 수행하기 이전에 실행된다.
     */
    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
