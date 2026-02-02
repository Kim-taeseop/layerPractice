package practice.layerPractice.sql;

/*
jpql 쿼리 메모용 클래스
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import practice.layerPractice.sql.sqlEntity.MemberSQL;
import practice.layerPractice.sql.sqlEntity.TeamSQL;

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
    String listSql1 = "select m From MemberSQL m where m.name like '%hello%'";
    String listSql2 = "select m From MemberSQL m where m.age > 20";
    List<MemberSQL> listResult = em.createQuery(listSql1, MemberSQL.class).getResultList();
    List<TeamSQL> listTeam = em.createQuery(
            "select t from MemberSQL m join m.teamSQL t", TeamSQL.class).getResultList();    // 조인 쿼리

    // 단일값 찾기
    MemberSQL singleResult = em.createQuery(
            "select m from MemeberSQL m where m.name = :name", MemberSQL.class)
            .setParameter("name", "member1")    // 파라미터 바인딩
            .getSingleResult();


    // Native SQL
    List<MemberSQL> listNative = em.createNativeQuery(
            "select name, age from MemberSQL where name = 'hello'", MemberSQL.class).getResultList();


}
