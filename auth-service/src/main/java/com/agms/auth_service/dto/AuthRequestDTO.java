package com.agms.auth_service.dto;


import lombok.Data;

@Data
public class AuthRequestDTO {
    private String username;
    private String password;
    private String Role;


}
