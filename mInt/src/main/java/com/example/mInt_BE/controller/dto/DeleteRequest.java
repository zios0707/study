package com.example.mInt_BE.controller.dto;

import lombok.Data;

@Data
public class DeleteRequest {
    private String id;
    private String ps;
    private String email;
}
