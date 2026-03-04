package practice.layerPractice.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import practice.layerPractice.dto.MemberDto;
import practice.layerPractice.entity.jpaEntity.Member;
import practice.layerPractice.repository.MemberRepository;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    // 도메인 클래스 컨버터 사용
    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member){
        return member.getUsername();
    }

    /*
    - Web 페이징 기능
    기본값 20개씩 나옴.
    ?page=0&size=3&sort=id,desc&sort=username,asc
    page : page 번호
    size : 사이즈 조절
    sort : 정렬 방정
    @PageableDefault : 페이징 개별 설정
     */
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5, sort = "username") Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        Page<MemberDto> map = page.map(member -> new MemberDto(member));
        return map;
    }

    @PostConstruct
    public void init() {
        for(int i = 0; i<100; i++) {
            memberRepository.save(new Member("user" + i, i, null));
        }
    }
}
