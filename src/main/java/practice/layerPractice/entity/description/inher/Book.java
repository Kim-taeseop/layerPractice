package practice.layerPractice.entity.description.inher;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B")    // 부모 클래스에서 @DiscriminatorColumn를 설정했을때 원래는 엔티티명이 뜨는데 그걸 바꿀수 있음.
public class Book extends Item{

    private String author;
    private String isbn;
}
