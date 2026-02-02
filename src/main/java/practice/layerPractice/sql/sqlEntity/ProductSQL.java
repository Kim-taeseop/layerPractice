package practice.layerPractice.sql.sqlEntity;

/*
JPQL를 연습하기 위한 엔티티
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductSQL {

    @Id @GeneratedValue
    @Column(name = "productSQL_id")
    private Long id;

    private String name;
    private int price;
    private int stockAmount;

}
