package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import study.datajpa.entity.Member;

import java.util.List;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final EntityManager em;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
