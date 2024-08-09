package com.github.gabrielrechbrand.javalab.mapper;

import com.github.gabrielrechbrand.javalab.dto.TruckDTO;
import com.github.gabrielrechbrand.javalab.mapper.generic.GenericMapper;
import com.github.gabrielrechbrand.javalab.model.Truck;
import org.springframework.stereotype.Component;

@Component
public class TruckMapper implements GenericMapper<TruckDTO, Truck> {

    @Override
    public TruckDTO toDTO(Truck entity) {
        return new TruckDTO(
                entity.getModel(),
                entity.getManufacturer(),
                entity.getYearOfManufacture(),
                entity.getLicensePlate(),
                entity.getCapacity()
        );
    }

    @Override
    public Truck toEntity(TruckDTO dto) {
        Truck truck = new Truck();
        truck.setModel(dto.model());
        truck.setManufacturer(dto.manufacturer());
        truck.setYearOfManufacture(dto.yearOfManufacture());
        truck.setLicensePlate(dto.licensePlate());
        truck.setCapacity(dto.capacity());

        return truck;
    }
}
