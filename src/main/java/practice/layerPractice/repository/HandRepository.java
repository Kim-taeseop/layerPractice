package practice.layerPractice.repository;

import org.springframework.stereotype.Repository;
import practice.layerPractice.entity.HandEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface HandRepository {

    // 저장
    HandEntity save(HandEntity handEntity);

    // id를 이용해 찾기 / Optional : null 값 대비
    Optional<HandEntity> findById(Long id);

    // 전부 찾기
    List<HandEntity> findAll();
}
