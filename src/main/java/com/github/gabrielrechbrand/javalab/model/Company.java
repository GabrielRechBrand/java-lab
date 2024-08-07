package com.github.gabrielrechbrand.javalab.model;

import jakarta.persistence.Entity;

@Entity
public class Company extends AbstractModel {

    private String name;
    private String identification;
    private String phone;
    private String email;

}
