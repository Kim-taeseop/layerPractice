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
public class MemberSQL {

    @Id @GeneratedValue
    @Column(name = "memberSQL_id")
    private Long id;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "teamSQL_id")
    private TeamSQL teamSQL;
}
