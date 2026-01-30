package practice.layerPractice.entity.description;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/*
임베디드 타입
Base Entity와 유사하지만
임베디드는 엔티티 안의 값 타입
베이스 엔티티는 엔티티의 공통 뼈대
임베디드 타입 같은 값 타입을 여러 엔티티가 공유하면 위험함. 한쪽에서 변경하면 다른엔티티도 변경
따라서 값을 복사해서 사용
 */
@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
