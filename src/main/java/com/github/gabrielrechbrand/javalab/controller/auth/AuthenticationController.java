package com.github.gabrielrechbrand.javalab.controller.auth;

import com.github.gabrielrechbrand.javalab.dto.auth.LoginResponseDTO;
import com.github.gabrielrechbrand.javalab.dto.auth.UserAuthenticationDTO;
import com.github.gabrielrechbrand.javalab.model.auth.User;
import com.github.gabrielrechbrand.javalab.dto.auth.UserRegisterDTO;
import com.github.gabrielrechbrand.javalab.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid UserAuthenticationDTO dto) {
        return ResponseEntity.ok(authenticationService.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterDTO dto) {
        return ResponseEntity.ok(authenticationService.register(dto));
    }

}
