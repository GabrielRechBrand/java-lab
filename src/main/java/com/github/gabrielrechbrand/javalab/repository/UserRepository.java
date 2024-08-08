package com.github.gabrielrechbrand.javalab.repository;

import com.github.gabrielrechbrand.javalab.model.auth.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends GenericRepository<User> {

    UserDetails findByLogin(String login);
}
