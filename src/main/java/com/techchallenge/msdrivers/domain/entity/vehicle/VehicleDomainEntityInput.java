package com.techchallenge.msdrivers.domain.entity.vehicle;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

public class VehicleDomainEntityInput {

    private String licensePlateNumber;
    private String brand;
    private String model;
    private DriverEntity driver;

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

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }
}
