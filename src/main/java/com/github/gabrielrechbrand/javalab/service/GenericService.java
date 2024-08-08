package com.github.gabrielrechbrand.javalab.service;

import com.github.gabrielrechbrand.javalab.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public abstract class GenericService<T> {

    @Autowired
    private GenericRepository<T> repository;

    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    public T findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    protected GenericRepository<T> getRepository() {
        return repository;
    }

}
