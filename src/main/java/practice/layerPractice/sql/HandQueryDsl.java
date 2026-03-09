package practice.layerPractice.sql;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import static practice.layerPractice.entity.jpaEntity.QMember.member;


public class HandQueryDsl {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    public void queryDsl() {
        queryFactory = new JPAQueryFactory(em);

        queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();
    }
}
