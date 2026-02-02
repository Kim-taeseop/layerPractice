package practice.layerPractice.sql;

/*
jpql 쿼리 메모용 클래스
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import practice.layerPractice.sql.sqlEntity.*;

import java.lang.reflect.Member;
import java.util.List;

public class HandJpql {

    EntityManager em;

    /*
    - jpql 특징
    query.getResultList(): 결과가 하나 이상일 때, 리스트 반환
    query.getSingleResult(): 결과가 정확히 하나     >> 한개가 아니면 예외 발생

    TypeQuery: 반환 타입이 명확할 때 사용
    Query: 반환 타입이 명확하지 않을 때 사용 -> 타입이 2개 이상
     */

    // List 찾기
    String listSql1 = "select distinct m from MemberSQL m where m.name like '%hello%'";  // 조건부 like, distinct : 중복제거
    String listSql2 = "select m from MemberSQL m where m.age > 20"; // 조건부 비교
    List<MemberSQL> listResult = em.createQuery(listSql1, MemberSQL.class).getResultList();

    Query query1 = em.createQuery("select m.name, m.age from MemberSQL m");  // 스칼라 타입 방식1
    List<MemberDTO> memberDTOResult = em.createQuery(
            "select new practice.layerPractice.sql.sqlEntity.MemberDTO(m.name, m.age) from MemberSQL m"
                    , MemberDTO.class).getResultList(); // 스칼라 타입 방식2  DTO 사용

    List<AddressSQL> orders = em.createQuery(
            "select o.addressSQL from OrderSQL o", AddressSQL.class).getResultList();   // 임베디드 사용


    // 페이징 setFirstResult(int start) : 조회 시작 위치  setMaxResults(int max) : 조회할 데이터 수
    List<MemberSQL> pagingResult = em.createQuery(
            "select m from MemberSQL m order by m.age desc", MemberSQL.class)
            .setFirstResult(0).setMaxResults(10)    // 0번째 부터 10개 들고가
            .getResultList();


    // 조인
    String joinSql1 = "select t from MemberSQL m join m.teamSQL t"; // inner join
    String joinSql2 = "select f from MemberSQL m left join m.teamSQL t";    // outer join
    String joinSql3 = "select count(m) from MemberSQL m, TeamSQL t where m.name = t.name";  // 세타 join(막 join) 연관관계가 없음
    String joinSql4 = "select m, t from MemberSQL m left join m.teamSQL t on t.name = 'A";  // on을 사용한 조인대상 필터링
    String joinSql5 = "select m, t from MemberSQL m left join TeamSQL t on m.name = t.name";    // on을 사용한 연관관계 없는 조인
    List<TeamSQL> listTeam = em.createQuery(joinSql1, TeamSQL.class).getResultList();


    // 단일값 찾기
    MemberSQL singleResult = em.createQuery(
            "select m from MemberSQL m where m.name = :name", MemberSQL.class)
            .setParameter("name", "member1")    // 파라미터 바인딩
            .getSingleResult();


    // Native SQL
    List<MemberSQL> listNative = em.createNativeQuery(
            "select name, age from MemberSQL where name = 'hello'", MemberSQL.class).getResultList();


}
