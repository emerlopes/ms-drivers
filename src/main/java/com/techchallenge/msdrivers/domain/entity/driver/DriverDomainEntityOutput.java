package com.techchallenge.msdrivers.domain.entity.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class DriverDomainEntityOutput {

    @JsonProperty("external_id")
    private UUID externalId;

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

}
