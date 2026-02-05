package practice.layerPractice.entity.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class MemberJPA {

    @Id @GeneratedValue
    @Column(name = "member_jpa_id")
    private Long id;

    private String name;
    private int age;

}
