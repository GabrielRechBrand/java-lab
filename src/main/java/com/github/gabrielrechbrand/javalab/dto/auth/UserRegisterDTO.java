package com.github.gabrielrechbrand.javalab.dto.auth;

import com.github.gabrielrechbrand.javalab.enumeration.UserRole;

public record UserRegisterDTO(String login, String password, UserRole role) {
}
