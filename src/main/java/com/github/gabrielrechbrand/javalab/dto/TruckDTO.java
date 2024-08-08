package com.github.gabrielrechbrand.javalab.dto;

import java.math.BigDecimal;

public record TruckDTO(
        String truckNumber,
        String model,
        String manufacturer,
        int yearOfManufacture,
        String licensePlate,
        BigDecimal capacity
) {}
