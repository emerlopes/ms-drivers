package com.techchallenge.msdrivers.repositories.driversdatabase.repository;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends JpaRepository<DriverEntity, Long> {
}
