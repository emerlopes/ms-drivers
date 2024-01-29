package com.techchallenge.msdrivers.application.entrypoint.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class DriverDTO {

    @CPF(message = "CPF inválido")
    // TODO: Criar uma anotacao para verificar se o CPF já existe na base
    private String cpf;
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String address;

}
