package com.techchallenge.msdrivers.domain.entity.vehicle;

import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.time.LocalDateTime;

public class VehicleDomainEntityOutput {

    private Long vehicleId;
    private String licensePlateNumber;
    private String brand;
    private String model;
    private DriverDomainEntityOutput driver;
    private LocalDateTime creationDate;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public DriverDomainEntityOutput getDriver() {
        return driver;
    }

    public void setDriver(DriverDomainEntityOutput driver) {
        this.driver = driver;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "VehicleDomainEntityOutput{" +
                "vehicleId=" + vehicleId +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", driver=" + driver +
                ", creationDate=" + creationDate +
                '}';
    }
}
