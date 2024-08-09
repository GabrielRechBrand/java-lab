package com.github.gabrielrechbrand.javalab.model;

import com.github.gabrielrechbrand.javalab.model.generic.AbstractModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Truck extends AbstractModel {

    private Boolean active;
    private String model;
    private String manufacturer;
    private Integer yearOfManufacture;
    private String licensePlate;
    private BigDecimal capacity;

}
