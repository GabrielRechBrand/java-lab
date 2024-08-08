package com.github.gabrielrechbrand.javalab.service;

import com.github.gabrielrechbrand.javalab.dto.TruckDTO;
import com.github.gabrielrechbrand.javalab.mapper.TruckMapper;
import com.github.gabrielrechbrand.javalab.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckService extends GenericService<Truck> {

    @Autowired
    private TruckMapper truckMapper;

    public Truck create(TruckDTO dto) {
        return save(truckMapper.toEntity(dto));
    }

}
