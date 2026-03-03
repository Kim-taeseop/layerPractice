package practice.layerPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practice.layerPractice.dto.MemberDto;
import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;
import java.util.Optional;

/*
Spring Data JPA 쿼리 메소드 관련 내용
 */

public interface MemberRepository extends JpaRepository<Member, Long> {

    /*
    - Spring Data JPA의 쿼리 메소드
    findBy A and B : where 처럼 조건으로 조회
    find...By : 전체 조회 (... : 이름 붙혀야함) (...By 하면 전체 기능 ex) count...By, exists...By, delete...By 등)
    GreaterThan : 특정값 보다 큰값 조회 (>)
    GreaterThanEqual : (>=)
    LessThan : 특정값 보다 작은값 조회 (<)
    LessThanEqual : (<=)
    Between : 범위 조회
    Is : 동일값 조회
    Not : 다른값 조회
    IsNotNull : null이 아닌값 조회
    Like : 문자열 조회
    In : 목록 포함
    NotIn : 목록 제외
    OrderBy : 정렬
    Top5 : 상위 5개
     */

    // 쿼리 메소드 사용 예시
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
    List<Member> findTop3HelloBy();

    // 네임드 쿼리 사용 예시
    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    // @Query, 리포지토리에 메소드 쿼리 정의
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    // 단순값 하나 조회
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    // DTO를 사용한 조회
    @Query("select new practice.layerPractice.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    // 파라미터 바인딩 in 절 사용
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    // 다양한 반환타입
    List<Member> findListByUsername(String username);   // 컬렉션
    Member findMemberByUsername(String username);   // 단건
    Optional<Member> findOptionalByUsername(String username);   // 단건 Optional
}
