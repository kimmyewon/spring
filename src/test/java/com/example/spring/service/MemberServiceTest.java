package com.example.spring.service;

import com.example.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService service = new MemberService();

    @AfterEach
    public void afterEach() {

    }

    @Test
    void join() {
        Member mem1 = new Member();
        mem1.setName("Service01");

        Long res = service.join(mem1);
        System.out.println("test_1 : " + res);

        Member findOne = service.findOne(res).get();

        Assertions.assertThat(findOne.getName()).isEqualTo(mem1.getId());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}