package com.example.spring.repository;

import com.example.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repo.clearAll();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Test1");
        repo.save(member);

        Member result = repo.findByName(member.getName()).get();

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member mem1 = new Member();
        mem1.setName("Test01");
        repo.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Test02");
        repo.save(mem2);

        Member finded = repo.findByName("Test01").get();

        Assertions.assertThat(mem1).isEqualTo(finded);
    }

    @Test
    public void findAll() {
        Member mem1 = new Member();
        mem1.setName("Test01");
        repo.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Test02");
        repo.save(mem2);

        List<Member> members = repo.findALl();

        for (Member member : members) {
            System.out.println("id: " + member.getId() + " / name : " + member.getName());
        }

        //Assertions.assertThat("비교대상").isEqualTo("예상되는결과");
        Assertions.assertThat(members.size()).isEqualTo(2);
    }


}
