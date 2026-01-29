package practice.layerPractice.entity.description;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/*
임베디드 타입
Base Entity와 유사하지만
임베디드는 엔티티 안의 값 타입
베이스 엔티티는 엔티티의 공통 뼈대
 */
@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
