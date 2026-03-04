package practice.layerPractice.dto;

import lombok.Data;
import practice.layerPractice.entity.jpaEntity.Member;

@Data
public class MemberDto {

    private Long id;
    private String username;
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
}
