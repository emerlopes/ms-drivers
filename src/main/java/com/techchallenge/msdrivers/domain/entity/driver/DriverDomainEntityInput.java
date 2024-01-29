package com.techchallenge.msdrivers.domain.entity.driver;

import lombok.Data;

@Data
public class DriverDomainEntityInput {

    private String cpf;
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
}
