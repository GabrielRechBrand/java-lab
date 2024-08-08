package com.github.gabrielrechbrand.javalab.controller;

import com.github.gabrielrechbrand.javalab.dto.TruckDTO;
import com.github.gabrielrechbrand.javalab.model.Truck;
import com.github.gabrielrechbrand.javalab.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @PostMapping
    public ResponseEntity<Truck> create(@RequestBody TruckDTO dto) {
        return ResponseEntity.ok(truckService.create(dto));
    }

}
