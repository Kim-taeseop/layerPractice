package practice.layerPractice.repository;

import practice.layerPractice.entity.jpaEntity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
