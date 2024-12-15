package com.hhp.precourse.service;

import com.hhp.precourse.domain.Member;
import com.hhp.precourse.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param member
     */
    public void join(Member member){
        memberRepository.save(member);
    }

    public void login(){}


}
