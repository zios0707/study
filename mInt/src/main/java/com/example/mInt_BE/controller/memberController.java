package com.example.mInt_BE.controller;


import com.example.mInt_BE.controller.dto.*;
import com.example.mInt_BE.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class memberController {

    private final MemberService memberService;

    @GetMapping("/hell")
    public String getHello() {
        return "Welcome!";
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {
        String result = memberService.join(joinRequest);
        return result;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        String result = memberService.login(loginRequest);
        return result;
    }

    @GetMapping("/info")
    public String info() {
        return "0";
    }

    @PostMapping("/changeId")
    public String idChange(@RequestBody IdChangeRequest idChangeRequest) {
        String result = memberService.idChange(idChangeRequest);
        return result;
    }

    @PostMapping("/changePs")
    public String psChange(@RequestBody PsChangeRequest psChangeRequest) {
        String result = memberService.psChange(psChangeRequest);
       return result;
    }

    @PostMapping("/changeEm")
    public String emChange(@RequestBody EmChangeRequest emChangeRequest) {
        String result = memberService.emChange(emChangeRequest);
        return result;
    }

    @PostMapping("/delete")
    public String DDelete(@RequestBody DeleteRequest deleteRequest) {
        String result = memberService.DDelete(deleteRequest);
        return result;
    }
}
