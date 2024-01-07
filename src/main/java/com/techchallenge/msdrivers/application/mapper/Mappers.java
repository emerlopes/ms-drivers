package com.techchallenge.msdrivers.application.mapper;



import com.techchallenge.msdrivers.application.builder.DriverDomainEntityInputBuilder;
import com.techchallenge.msdrivers.application.builder.DriverDomainEntityOutputBuilder;
import com.techchallenge.msdrivers.application.builder.DriverEntityBuilder;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.util.ArrayList;
import java.util.List;

public class Mappers {
    public static DriverDomainEntityInput mapToPersonDomainEntityInput(DriverDTO driverDTO) {
        return new DriverDomainEntityInputBuilder()
                .withCpf(driverDTO.getCpf())
                .withName(driverDTO.getName())
                .withAge(driverDTO.getAge())
                .withPhoneNumber(driverDTO.getPhoneNumber())
                .build();
    }

    public static DriverDomainEntityOutput mapToPersonDomainEntityOutput(DriverEntity driverEntity) {
        return new DriverDomainEntityOutputBuilder()
                .withExternalId(driverEntity.getExternalId())
                .withName(driverEntity.getName())
                .withAge(driverEntity.getAge())
                .withPhoneNumber(driverEntity.getPhoneNumber())
                .build();
    }

    public static List<DriverDomainEntityOutput> mapToPersonDomainEntitiesOutput(List<DriverEntity> personEntities) {
        List<DriverDomainEntityOutput> outputs = new ArrayList<>();

        for (DriverEntity driverEntity : personEntities) {
            final var output = new DriverDomainEntityOutputBuilder()
                    .withExternalId(driverEntity.getExternalId())
                    .withName(driverEntity.getName())
                    .withAge(driverEntity.getAge())
                    .withPhoneNumber(driverEntity.getPhoneNumber())
                    .build();

            outputs.add(output);
        }

        return outputs;
    }

    public static DriverEntity mapToPersonEntity(DriverDomainEntityInput driverDomainEntityInput) {
        return new DriverEntityBuilder()
                .withCpf(driverDomainEntityInput.getCpf())
                .withName(driverDomainEntityInput.getName())
                .withAge(driverDomainEntityInput.getAge())
                .withPhoneNumber(driverDomainEntityInput.getPhoneNumber())
                .build();


    }
}
