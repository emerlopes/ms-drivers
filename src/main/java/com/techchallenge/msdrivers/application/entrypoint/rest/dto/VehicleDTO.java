package com.techchallenge.msdrivers.application.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class VehicleDTO {

    @JsonProperty("license_plate_number")
    private String licensePlateNumber;

    private String brand;
    private String model;

    @JsonProperty("driver_external_id")
    private UUID driverExternalId;

}
