package practice.layerPractice.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.layerPractice.entity.jpaEntity.Member;

@Data
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String username;
    private int age;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }
    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
    }

    // Dto 도 Q파일로 만들어주는 어노테이션
    @QueryProjection
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
