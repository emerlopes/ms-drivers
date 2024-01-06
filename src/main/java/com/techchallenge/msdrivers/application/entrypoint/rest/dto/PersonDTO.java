package com.techchallenge.msdrivers.application.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PersonDTO {

    @CPF(message = "CPF inválido")
    private String cpf;
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

}
