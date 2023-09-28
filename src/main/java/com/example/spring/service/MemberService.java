package com.example.spring.service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    //회원가입
    public Long join(Member member) {
        //같은 이름 있는 중복회원 X 이라는 조건 추가
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    //회원검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체회원조회
    public List<Member> findMembers() {
       return memberRepository.findALl();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);       
    }
}
