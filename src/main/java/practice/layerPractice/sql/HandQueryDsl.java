package practice.layerPractice.sql;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import practice.layerPractice.dto.MemberDto;
import practice.layerPractice.dto.QMemberDto;
import practice.layerPractice.entity.jpaEntity.Member;
import practice.layerPractice.entity.jpaEntity.QMember;

import java.util.List;

import static practice.layerPractice.entity.jpaEntity.QMember.member;
import static practice.layerPractice.entity.jpaEntity.QTeam.team;

/*
QueryDSL 관련 클래스
 */

public class HandQueryDsl {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    public void queryDsl() {
        queryFactory = new JPAQueryFactory(em);
        QMember memberSub = new QMember("memberSub");

        // 일반적인 qeuryDsl 사용
        List<Member> result1 = queryFactory
                .select(member)
                .from(member)
                .where(     // 조건
                        member.username.eq("member1"),
                        member.age.eq(  // 서브쿼리 작성
                                JPAExpressions
                                        .select(memberSub.age.max())
                                        .from(memberSub)
                        )
                )
                .orderBy(   // 정렬
                        member.age.desc(),
                        member.username.asc().nullsFirst()
                )
                .offset(1)  // 페이징. 0부터 시작임.
                .limit(2)   // 2개씩 끊어서
                .fetch();

        // 함수 및 그룹, 조입 사용 결과 타입이 여러개일때 tuple 사용 >> 실무는 DTO
        List<Tuple> result2 = queryFactory
                .select(team.name, member.age.avg())
                .from(member)               // from(엔티티 2개를 넣어 세타조인 가능)
                .join(member.team, team).fetchJoin()  // (조인 대상, 별칭으로 사용할 Q타입), .fetchJoin(): 페치조인 사용
                    .on(team.name.eq("teamA"))  // inner 조인은 where쓰고, outer일때 on절 사용
                // from(member, team) 세타조인 -> leftjoin(team).on(member.username.eq(team.name)) 이런식 사용
                .groupBy(team.name)
                .fetch();

        Tuple team1 = result2.get(0);
        Tuple team2 = result2.get(1);
        Integer max1 = team1.get(member.age.max());
        Double avg2 = team2.get(member.age.avg());

        /* - 결과를 Dto로 반환
        Projections.bean : 프로퍼티 접근 - Setter 사용
        Projections.fields : 필드 접근 방식
        Projections.constructor : 생성자 사용 방식
         */
        List<MemberDto> result3 = queryFactory
                .select(Projections.bean(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();

        // @QueryProjection 를 이용한 dto 방식
        List<MemberDto> result4 = queryFactory
                .select(new QMemberDto(member.username, member.age))
                .from(member)
                .fetch();

        // 동적 쿼리 사용
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result5 = searchMember1(usernameParam, ageParam);   // 동적 쿼리 - BooleanBuilder 사용
        List<Member> result6 = searchMember2(usernameParam, ageParam);   // 동적 쿼리 - Where 다중 파라미터 사용

        // 벌크 연산  update, delete
        long count = queryFactory
                .update(member)     // delete하면 삭제
                .set(member.username, "비회원")
                // .set(member.age, member.age.add(1) || member.age.multiply(2) 이런식 벌크 연산.
                .where(member.age.lt(28))   // age<28
                .execute();

        em.flush();
        em.clear(); // 벌크 연산은 버로 DB로 가기 때문에 플러쉬 클리어 해줘야함.
    }

    private List<Member> searchMember1(String usernameCond, Integer ageCond) {

        BooleanBuilder builder = new BooleanBuilder();
        if(usernameCond != null){
            builder.and(member.username.eq(usernameCond));
        }
        if(ageCond != null){
            builder.and(member.age.eq(ageCond));
        }

        return queryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();
    }

    private List<Member> searchMember2(String usernameCond, Integer ageCond) {
        return queryFactory
                .selectFrom(member)
                .where(usernameEq(usernameCond), ageEq(ageCond))    // null은 무시됨.
                .fetch();
    }

    private Predicate usernameEq(String usernameCond) {
        if (usernameCond != null){
            return member.username.eq(usernameCond);
        }else {
            return null;
        }
    }

    private Predicate ageEq(Integer ageCond) {
        if(ageCond == null){
            return null;
        }else {
            return member.age.eq(ageCond);
        }
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

    - join
    join() : 내부 조인(inner join)
    leftJoin() : left 외부 조인(left outer join)
    rightJoin() : right 외부 조인(right outer join)

    - case 문
    when, then 사용
    범위 설정 -> new CaseBuilder()
            .when(member.age.between(0, 20)).then("0~20살")
            .when(member.age.between(21, 30)).then("21~30살")
            .otherwise("기타")
     */
}
