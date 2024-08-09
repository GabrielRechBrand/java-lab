package com.github.gabrielrechbrand.javalab.enumeration;

import lombok.Getter;

@Getter
public enum UserRole {

    BASIC("basic"),
    ADMIN("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
