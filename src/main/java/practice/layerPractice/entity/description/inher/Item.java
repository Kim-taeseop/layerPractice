package practice.layerPractice.entity.description.inher;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
상속관계 매핑을 위한 엔티티 Item / Book
Album, Movie, Book을 그냥 다 Item 상속 시키면 통합 테이블 형식으로 데이터베이스 만들어짐
@Inheritance 로 상속 매핑 설정 할수 있음
strategy = InheritanceType.JOINED : 조인 전략
strategy = InheritanceType.SINGLE_TABLE : 통합 테이블
strategy = InheritanceType.TABLE_PER_CLASS : 구현 클래스 마다 테이블  // 사실 잘 안씀.
 */
@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn    // 이 어노테이션을 하면 Item 테이블에 DTYPE 이라는 상속된 엔티티 명이 들어감 (name = "")으로 변경 가능
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
