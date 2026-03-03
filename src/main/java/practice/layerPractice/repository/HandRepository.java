package practice.layerPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.layerPractice.entity.Hand;


@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {

}
