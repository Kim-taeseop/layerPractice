package practice.layerPractice.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import practice.layerPractice.dto.MemberDto;
import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;
import java.util.Optional;

/*
Spring Data JPA 쿼리 메소드 관련 내용
 */

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

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

    // Spring Data JPA 를 사용한 페이징
    Page<Member> findByAge(int age, Pageable pageable);     // 카운트 쿼리 포함
    Slice<Member> findByUsername(String name, Pageable pageable);   // 카운트 쿼리 없이 다음페이지 확인
    // 카운트 쿼리 분리 -> 프로젝트 규모가 커지면 카운트 쿼가 무거워짐
    @Query(value = "select m from Member m",
            countQuery = "select count(m.username) from Member m")
    Page<Member> findMemberAllCountBy(Pageable pageable);
    /*
    사용 방식
    PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
    Page<Member> page = memberRepository.findByAge(age, pageRequest);

    Page<MemberDto> toMap = page.map(m -> new MemberDto(m.getId(), m.getUsername(), null);  // Page Dto로 변환

    List<Member> content = page.getContent(); -> paging 한번 한 단위
    long total = page.getTotalElements(); -> 총 데이터 수
    int num = page.getNumber(); -> 페이지 번호
    int totalPage = page.getTotalPages(); -> 총 페이지 개수
    */

    // 벌크성 수정 spring data jpa 기준
    @Modifying(clearAutomatically = true)   // 벌크 연산은 DB에 바로 저장하기 때문에 이 쿼리 이후 자동으로 영속성 반영 및 저장을 함. -> 다른 연산에 영향 안미치게
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    // jpql fetch join
    @Query("select m from Member m join fetch m.team")
    List<Member> findMemberFetchJoin();

    // EntityGraph -> @EntityGraph를 통해 team과 fetch join 해줌
    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();

    //JPQL + 엔티티 그래프
    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

    // 메서드이름 쿼리에서 엔티티 그래프 사용
    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(@Param("username") String username);

    // 네임드 엔티티 그래프 사용
    @EntityGraph("Member.all")
    List<Member> findNamedGraphByUsername(@Param("username") String username);

    // 쿼리 힌트 사용
    @QueryHints(value = {@QueryHint(name = "org.hibernate.readOnly", value = "true")}, forCounting = true)
    Member findReadOnlyByUsername(String username);

    //해당 row를 조회하는 순간 다른 트랜잭션이 그 데이터를 수정하지 못하게 막음
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
}
