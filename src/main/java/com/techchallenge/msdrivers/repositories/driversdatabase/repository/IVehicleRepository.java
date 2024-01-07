package com.techchallenge.msdrivers.repositories.driversdatabase.repository;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
