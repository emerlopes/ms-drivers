package com.techchallenge.msdrivers.domain.entity.vehicle;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import lombok.Data;

@Data
public class VehicleDomainEntityInput {

    private String licensePlateNumber;
    private String brand;
    private String model;
    private DriverEntity driver;

}
