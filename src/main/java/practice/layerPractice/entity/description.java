package practice.layerPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
// @Table(uniqueConstraints = ) : 컬럼에 유니크 제약조건을 걸고자 할때
public class description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
