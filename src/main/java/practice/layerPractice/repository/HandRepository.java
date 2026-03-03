package practice.layerPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practice.layerPractice.dto.MemberDto;
import practice.layerPractice.entity.Hand;
import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;

/*
Spring Data JPA 쿼리 메소드 관련 내용
 */
@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {

}
