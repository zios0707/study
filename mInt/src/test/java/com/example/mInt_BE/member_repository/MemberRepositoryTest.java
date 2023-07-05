package com.example.mInt_BE.member_repository;

import com.example.mInt_BE.repository.MemberRepository;
import com.example.mInt_BE.repository.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void crudTest() {
        Member member = Member.builder()
                .id("zios")
                .ps("강현욱")
                .email("010-1222-2333")
                .build();

        memberRepository.save(member);

        Member foundMember = memberRepository.findById(1L).get();
    }
}