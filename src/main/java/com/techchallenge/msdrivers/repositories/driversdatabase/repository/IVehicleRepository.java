package com.techchallenge.msdrivers.repositories.driversdatabase.repository;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleRepository extends JpaRepository<VehicleEntity, Long> {

    Optional<List<VehicleEntity>> findByDriver(DriverEntity driver);
}
