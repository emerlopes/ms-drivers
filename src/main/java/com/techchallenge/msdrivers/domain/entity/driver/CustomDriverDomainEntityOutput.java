package com.techchallenge.msdrivers.domain.entity.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CustomDriverDomainEntityOutput {

    @JsonProperty("external_id")
    private UUID externalId;

    private String name;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
