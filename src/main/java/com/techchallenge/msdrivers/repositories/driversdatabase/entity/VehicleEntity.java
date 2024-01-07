package com.techchallenge.msdrivers.repositories.driversdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb02_vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(name = "license_plate_number", nullable = false)
    private String licensePlateNumber;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "external_driver_id", nullable = false)
    private DriverEntity driver;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
