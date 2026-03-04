package practice.layerPractice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;

/*
- 사용자 정의 리포지토리
메서드를 직접 구현하고자 할때
JPA 직접 사용, Mybatis, QueryDSL 등
규칙: 리포지토리 인터페이스 이름 + Impl -> 스프링 데이터 JPA가 인식해서 스프링 빈으로 등록
MemberRepositoryImpl : 사용자 정의 메소드 구현 클래스
MemberRepositoryCustom : 사용자 정의 인터페이스
MemberRepository : 인터페이스에서 사용자 정의 인터페이스 상속

참고: 항상 사용자 정의 리포지토리가 필요한 것은 아니다. 그냥 임의의 리포지토리를 만들어도 된다.
예를들어 MemberQueryRepository를 인터페이스가 아닌 클래스로 만들고 스프링 빈으로 등록해서 그냥 직접 사용해도 된다.
물론 이 경우 스프링 데이터 JPA와는 아무런 관계 없이 별도로 동작한다.

 */
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
