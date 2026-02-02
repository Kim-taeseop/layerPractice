package practice.layerPractice.sql.sqlEntity;

/*
JPQL를 연습하기 위한 엔티티
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class TeamSQL {

    @Id @GeneratedValue
    @Column(name = "teamSQL_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "teamSQL")
    private List<MemberSQL> memberSQLList = new ArrayList<>();
}
