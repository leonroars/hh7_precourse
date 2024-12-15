package com.hhp.precourse.repository.member;

import com.hhp.precourse.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
