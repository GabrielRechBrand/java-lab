package com.github.gabrielrechbrand.javalab.model;

import jakarta.persistence.Entity;

@Entity
public class Customer extends AbstractModel {

    private String name;
    private String email;
    private String phone;


}
