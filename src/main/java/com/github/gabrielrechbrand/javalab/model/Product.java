package com.github.gabrielrechbrand.javalab.model;

import com.github.gabrielrechbrand.javalab.enumeration.ProductCategory;
import com.github.gabrielrechbrand.javalab.enumeration.ProductStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
public class Product extends AbstractModel {

    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private ProductStatus status;
    private ProductCategory category;
    private BigDecimal weight;

    @ManyToOne
    private Company company;

}
