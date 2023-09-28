package com.example.spring.repository;

import com.example.spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> memberInfo = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        memberInfo.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberInfo.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberInfo.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findALl() {
        return new ArrayList<>(memberInfo.values());
    }

    public void clearAll() {
        memberInfo.clear();
    }
}
