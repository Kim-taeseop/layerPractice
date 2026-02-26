package practice.layerPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.layerPractice.entity.Hand;
import practice.layerPractice.entity.jpaEntity.MemberJPA;

import java.util.List;
import java.util.Optional;

@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {

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

    // 이름이 같고 나이가 특정값 초과인 예시
    List<MemberJPA> findByUsernameAndAgeGreaterThan(String username, int age);
}
