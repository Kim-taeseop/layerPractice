package practice.layerPractice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import practice.layerPractice.dto.MemberSearchCondition;
import practice.layerPractice.dto.MemberTeamDto;
import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();

    List<MemberTeamDto> search(MemberSearchCondition condition);
    // Spring Data JPA + QueryDsl paging  전체 카운트를 한번에 조회
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
    // Spring Data JPA + QueryDsl paging  데이터 내용과 전체 카운트를 별도로 조회
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);
}
