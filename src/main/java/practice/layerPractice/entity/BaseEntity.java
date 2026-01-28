package practice.layerPractice.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*
@MappedSuperclass
상속 관계 X, 엔티티 X, 테이블과 매핑 X
상속 받는 자식 클래스에 매핑 정보만 제공
 */

@Setter
@Getter
@MappedSuperclass   // 공통되는 정보를 넣는 기본 엔티티 선언. 사용 엔티티에 extends BaseEntity
public abstract class BaseEntity {

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
