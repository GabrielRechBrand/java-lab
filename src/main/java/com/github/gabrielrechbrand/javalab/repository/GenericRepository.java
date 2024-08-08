package com.github.gabrielrechbrand.javalab.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GenericRepository<T> extends CrudRepository<T, UUID> {
}
