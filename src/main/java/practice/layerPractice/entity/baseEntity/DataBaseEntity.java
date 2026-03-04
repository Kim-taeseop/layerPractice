package practice.layerPractice.entity.baseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
Spring Data JPA 사용한 기본 BaseEntity 생성 (생성, 수정 시간, 생성자, 수정자)

BaseTimeEntity 를 따로 만들어서 최상위 클래스로 두고 현재 클래스에서는 생성자, 수정자만 만든 후 상속 받는게 좋을 수 있음
-> 생성, 수정 시간은 항상 사용하고 생성자, 수정자는 별도로 쓰기 위함.
 */


@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class DataBaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}
