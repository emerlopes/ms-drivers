package com.techchallenge.msdrivers.application.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDTO {

    private String cpf;
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

}
