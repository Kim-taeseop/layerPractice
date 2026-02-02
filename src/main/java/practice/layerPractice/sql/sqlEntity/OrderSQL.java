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
public class OrderSQL {

    @Id @GeneratedValue
    @Column(name = "orderSQL_id")
    private Long id;

    private int orderAmount;

    @Embedded
    private AddressSQL addressSQL;

    @ManyToOne
    @JoinColumn(name = "productSQL_id")
    private ProductSQL productSQL;

}
