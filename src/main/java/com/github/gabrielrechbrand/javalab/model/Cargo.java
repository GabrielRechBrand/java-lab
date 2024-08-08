package com.github.gabrielrechbrand.javalab.model;

import com.github.gabrielrechbrand.javalab.enumeration.CargoStatus;
import com.github.gabrielrechbrand.javalab.model.generic.AbstractModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cargo extends AbstractModel {

    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String origin;
    private String destination;
    private CargoStatus status;
    private BigDecimal totalWeight;
    private BigDecimal volume;
    private BigDecimal temperature;
    private Boolean hazardousMaterial;
    private String insurancePolicyNumber;
    private LocalDateTime loadingStartTime;
    private LocalDateTime loadingEndTime;
    private LocalDateTime unloadingStartTime;
    private LocalDateTime unloadingEndTime;
    private String notes;

    @ManyToOne
    private Truck truck;

    @ManyToMany
    @JoinTable(name = "cargo_product", joinColumns = @JoinColumn(name = "cargo_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

}
