package com.github.gabrielrechbrand.javalab.service.auth;

import com.github.gabrielrechbrand.javalab.dto.auth.LoginResponseDTO;
import com.github.gabrielrechbrand.javalab.dto.auth.UserAuthenticationDTO;
import com.github.gabrielrechbrand.javalab.model.auth.User;
import com.github.gabrielrechbrand.javalab.dto.auth.UserRegisterDTO;
import com.github.gabrielrechbrand.javalab.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponseDTO login(@Valid UserAuthenticationDTO dto) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        Authentication authentication = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) authentication.getPrincipal());

        return new LoginResponseDTO(token);
    }

    public User register(@Valid UserRegisterDTO dto) {
        if(userRepository.findByLogin(dto.login()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }

        String password = new BCryptPasswordEncoder().encode(dto.password());

        return userRepository.save(new User(dto.login(), password, dto.role()));
    }
}
