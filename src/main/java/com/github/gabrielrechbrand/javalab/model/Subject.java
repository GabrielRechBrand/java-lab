package com.github.gabrielrechbrand.javalab.model;

import com.github.gabrielrechbrand.javalab.enumeration.SubjectType;
import com.github.gabrielrechbrand.javalab.model.generic.AbstractModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subject extends AbstractModel {

    private String name;
    private String email;
    private String phone;
    private String address;
    private SubjectType type;

}
