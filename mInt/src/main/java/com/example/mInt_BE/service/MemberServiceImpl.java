package com.example.mInt_BE.service;


import com.example.mInt_BE.controller.dto.*;
import com.example.mInt_BE.repository.MemberRepository;
import com.example.mInt_BE.repository.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String join(JoinRequest joinRequest) {
        Optional<Member> member = Optional.ofNullable(memberRepository.findByIdAndPs(joinRequest.getId(), joinRequest.getPs()));
        if (member.isPresent()) {
            return "false - Not a unique!";
        } else {
            Member newMember = Member.builder()
                    .id(joinRequest.getId())
                    .ps(joinRequest.getPs())
                    .email(joinRequest.getEmail())
                    .build();
            memberRepository.save(newMember);
            return "success";
        }
    }

     @Override
    public String login(LoginRequest loginRequest) {
         Member member = memberRepository.findByIdAndPs(loginRequest.getId(), loginRequest.getPs());

         if (member != null) {
             return "success";
         }else {
             return "false";
         }
     }

     @Override
    public String idChange(IdChangeRequest idChangeRequest) {
         Member member = memberRepository.findByIdAndPs(idChangeRequest.getId(), idChangeRequest.getPs());
         if (member != null) {
             //인증 성공시 계속 진행, 바꾸기
             member.setId(idChangeRequest.getVal());
             memberRepository.save(member);
             return "success";
         }else {
             //인증 실패시 체인징 실패
             return "false";
         }

     }

     @Override
    public String psChange(PsChangeRequest psChangeRequest) {
         Member member = memberRepository.findByIdAndPs(psChangeRequest.getId(), psChangeRequest.getPs());
         if (member != null) {
             //인증 성공시 계속 진행, 바꾸기
             member.setPs(psChangeRequest.getVal());
             memberRepository.save(member);
             return "success";
         }else {
             //인증 실패시 체인징 실패
             return "false";
         }
     }

     @Override
    public String emChange(EmChangeRequest emChangeRequest) {
         Member member = memberRepository.findByIdAndPs(emChangeRequest.getId(), emChangeRequest.getPs());
         if (member != null) {
             //인증 성공시 계속 진행, 바꾸기
             member.setEmail(emChangeRequest.getVal());
             memberRepository.save(member);
             return "success";
         }else {
             //인증 실패시 체인징 실패
             return "false";
         }
     }

     @Override
    public String DDelete(DeleteRequest deleteRequest) {
        Member member = memberRepository.findByIdAndPsAndEmail(deleteRequest.getId(), deleteRequest.getPs(), deleteRequest.getEmail());

        if(member != null) {
            memberRepository.delete(member);
            return "success";
        }else {
            return "false - value error!";
        }
    }

}
