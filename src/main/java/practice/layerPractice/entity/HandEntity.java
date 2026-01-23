package practice.layerPractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HandEntity {

    @Id
    private Long id;
    private String name;
}
