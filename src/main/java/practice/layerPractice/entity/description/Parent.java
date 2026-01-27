package practice.layerPractice.entity.description;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import practice.layerPractice.entity.RoleType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
// @Table(uniqueConstraints = ) : 컬럼에 유니크 제약조건을 걸고자 할때
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parents_id")
    private Long id;
    /*
    기본 키 제약 조건 : Not null, 유일, 변하면 안됨.
    기본 키 매핑 직접 할거면 @Id만
    자동 생성 : @GeneratedValue
    strategy = GenerationType.~~  : 자동 매핑 설정
    GenerationType.AUTO : DB 방언에 따라 자동으로 생성.  설정은 아래 3가지
    GenerationType.IDENTITY : 데이터베이스에 위임. 주로 MySQL. ex) MySQL 의 Auto_increment
    GenerationType.SEQUENCE : 주로 Oracle. 시퀀스 오브젝트를 통해 값을 생성
    GenerationType.TABLE : 키 생성용 테이블을 따로 만듬. 모든 데이터베이스 사용 가능. 성능이 안좋음
     */

    @Column(name = "name")
    private String username;
    /*
    @Column 종류 및 설명
    name : 필드와 매핑할 테이블의 컬럼 이름
    insertable, updatable : 등록, 변경 가능여부(어플에서) T/F
    nullable(DDL) : null 값 허용 여부 T/F
    unique(DDL) : 컬럼에 유니크 제약조건
    columnDefinition(DDL) : 데이터베이스 컬럼 정보를 직접 줌
    length(DDL) : 문자 길이 제약 조건 (String 타입 만, 기본 255)
     */

    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /*
    enum 타입 설명
    enum(미리 정해진 값만 가질수 있음) 타입을 쓰기 위함
    EnumType.STRING, ORDINAL(기본) 이 있음
    ORDINAL : enum 타입의 순서(숫자) 가 들어감 수정시 반영 안됨 사용XXX
    STRING : enum 의 이름을 데이터베이스에 저장
     */

    // 시간 정보 타입
    private LocalDate localDateTest;
    private LocalDateTime localDateTimeTest;

    @Lob    // varchar 이상의 큰 글자
    private String description;

    @Transient  // 데이터베이스에서 사용하지 않음
    private int temp;

    @ManyToOne
    @JoinColumn(name = "son_id")
    @Setter(AccessLevel.NONE)
    private Son son;
    /*
    - 단방향 연관관계
    호출할 엔티티에서
    @ManyToOne
    @JoinColumn(name = "team_id")
    이것만 해주면 끝 ManyToOne : N:1

    - 양방향 연관관계
    사실 양방향은 단방향이 2개인 연관관계
    테이블은 양방향 / 객체는 단방향 2개
    연관관계의 주인은 외래키가 있는곳으로 설정 >> N쪽이 주인임.
    주인 : 조회, 수정, 삭제 가능 / 주인 아닌 객체 : 읽기만 가능

    - 양방향 매핑시 실수
    객체에 값을 입력할때 주인에 해야함. ex) Team의 List<Member> members에 넣으면 안됨
    주인에만 넣어도 jpa는 돌아가지만 테스트케이스/1차 캐쉬 등 때문에 양쪽 객체에 다 넣어주는게 좋음
    >> 양방향을 매번 하기 보다 아래 처럼 Setter 메서드에 추가로 넣어서 자동으로 하게 하기.
    사실 양방향은 우선 단방향으로 설계를 끝낸 후 필요시 아래 코드 추가 및 Son에 매핑 추가 해주는게 좋음.
    양방향 매핑에서 무한루프 조심. ex) toString(), lombok, JSON 생성 라이브러리

    - @Setter(AccessLevel.NONE)
    Setter 금지 따로 만들어 써야함
     */

    public void setSon(Son son){
        this.son = son;
        // 양방향 매핑에서 한번의 호출로 양 객체에 값을 다 넣기 위함.
        son.getParents().add(this);
    }
}
