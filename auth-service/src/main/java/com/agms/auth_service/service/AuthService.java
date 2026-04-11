package com.agms.auth_service.service;

import com.agms.auth_service.dto.AuthRequestDTO;
import com.agms.auth_service.dto.AuthResponse;
import com.agms.auth_service.dto.LoginRequest;

public interface AuthService {
    void register(AuthRequestDTO request);

    AuthResponse login(LoginRequest request);
}
