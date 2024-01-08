package com.techchallenge.msdrivers.domain.entity.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class DriverDomainEntityOutput {

    @JsonProperty("external_id")
    private UUID externalId;

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("vehicle")
    private List<VehicleEntity> vehicle;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
