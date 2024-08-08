package com.github.gabrielrechbrand.javalab.mapper.generic;

public interface GenericMapper<D, E> {
    D toDTO(E entity);
    E toEntity(D dto);
}
