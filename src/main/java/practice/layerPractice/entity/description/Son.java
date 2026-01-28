package practice.layerPractice.entity.description;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
설명 엔티티중 양방향 매핑의 주인이 아닌 객체
 */

@Getter
@Setter
@Entity
public class Son {

    @Id
    @GeneratedValue
    @Column(name = "son_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "son")
    private List<Parent> parents = new ArrayList<>();
    /*
    Parent의 son 객체와 연관관계
    mappedBy = : 양방향에서 주인이 아닌 객체에 설정
     */
}
