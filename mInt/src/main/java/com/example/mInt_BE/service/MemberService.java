package com.example.mInt_BE.service;

import com.example.mInt_BE.controller.dto.*;

public interface MemberService {
    String join(JoinRequest joinRequest);
    String login(LoginRequest loginRequest);
    String idChange(IdChangeRequest idChangeRequest);
    String psChange(PsChangeRequest psChangeRequest);
    String emChange(EmChangeRequest emChangeRequest);
    String DDelete(DeleteRequest deleteRequest);
}
