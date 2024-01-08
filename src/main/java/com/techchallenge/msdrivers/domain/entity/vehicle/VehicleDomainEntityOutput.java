package com.techchallenge.msdrivers.domain.entity.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.msdrivers.domain.entity.driver.CustomDriverDomainEntityOutput;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleDomainEntityOutput {


    @JsonProperty("vehicle_id")
    private Long vehicleId;

    @JsonProperty("license_plate_number")
    private String licensePlateNumber;

    private String brand;
    private String model;
    private CustomDriverDomainEntityOutput driver;

    @JsonProperty("creation_at")
    private LocalDateTime creationAt;

}
