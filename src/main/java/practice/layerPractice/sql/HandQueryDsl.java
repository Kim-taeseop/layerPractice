package practice.layerPractice.sql;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import static practice.layerPractice.entity.jpaEntity.QMember.member;

/*
QueryDSL 관련 클래스
 */

public class HandQueryDsl {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    public void queryDsl() {
        queryFactory = new JPAQueryFactory(em);

        queryFactory
                .select(member)
                .from(member)
                .where(     // 조건
                        member.username.eq("member1"),
                        member.age.eq(10)
                )
                .orderBy(   // 정렬
                        member.age.desc(),
                        member.username.asc().nullsFirst()
                )
                .offset(1)  // 페이징. 0부터 시작임.
                .limit(2)   // 2개씩 끊어서
                .fetch();
    }

    /*
    - .fetch 관련
    fetch()	: List 조회
    fetchOne() : 정확히 1개
    fetchFirst() : 첫 번째 1개
    // 아래 2개 이제 안쓰고 count 쿼리를 따로 만들어 사용
    fetchCount() : count 조회
    fetchResults() : 페이징 정보 포함, total count 쿼리 추가 실행

    - 검색 조건
    member.username.eq("member1") // username = 'member1'
    member.username.ne("member1") //username != 'member1'
    member.username.eq("member1").not() // username != 'member1'

    member.username.isNotNull() //이름이 is not null

    member.age.in(10, 20) // age in (10,20)
    member.age.notIn(10, 20) // age not in (10, 20)
    member.age.between(10,30) //between 10, 30

    member.age.goe(30) // age >= 30
    member.age.gt(30) // age > 30
    member.age.loe(30) // age <= 30
    member.age.lt(30) // age < 30

    member.username.like("member%") //like 검색
    member.username.contains("member") // like ‘%member%’ 검색
    member.username.startsWith("member") //like ‘member%’ 검색
     */
}
