package practice.layerPractice.entity.description.cascade;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
영속성 전이 및 고아 객체 설명을 위한 엔티티
 */

@Entity
@Getter
@Setter
public class Mon {

    @Id @GeneratedValue
    @Column(name = "mon_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "mon", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private List<Child> childList = new ArrayList<>();
    /*
    - 영속성 전이
    특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함께 영속 상태로 만들고 싶을 때
    한 엔티티가 여러 엔티티와 관계가 있을땐 쓰면 안됨.
    CascadeType.ALL : 모두 적용
    CascadeType.PERSIST : 영속
    CascadeType.REMOVE : 삭제

    - 고아 객체
    orphanRemoval = true
    위 설정을 하면 부모 엔티티와 연관관계가 끊어진 엔티티 자동 삭제
    CascadeType.REMOVE처럼 동작
    @OneTo~  만 사용 가능

    CascadeType.ALL + orphanRemoval = true
    두 옵션을 모두 활성화 하면 부모 엔티티를 통해 자식의 생명주기를 관리 할 수 있음
     */

    public void addChild(Child child){
        childList.add(child);
        child.setMon(this);
    }
}
