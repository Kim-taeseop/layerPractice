package practice.layerPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.layerPractice.entity.Hand;

import java.util.List;
import java.util.Optional;

@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {

    // 저장
    Hand save(Hand handEntity);

    // id를 이용해 찾기 / Optional : null 값 대비
    Optional<Hand> findById(Long id);

    // 전부 찾기
    List<Hand> findAll();
}
