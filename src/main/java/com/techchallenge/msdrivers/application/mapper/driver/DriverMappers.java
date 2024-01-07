package com.techchallenge.msdrivers.application.mapper.driver;



import com.techchallenge.msdrivers.application.builder.driver.DriverDomainEntityInputBuilder;
import com.techchallenge.msdrivers.application.builder.driver.DriverDomainEntityOutputBuilder;
import com.techchallenge.msdrivers.application.builder.driver.DriverEntityBuilder;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.util.ArrayList;
import java.util.List;

public class DriverMappers {
    public static DriverDomainEntityInput mapToDriverDomainEntityInput(DriverDTO driverDTO) {
        return new DriverDomainEntityInputBuilder()
                .withCpf(driverDTO.getCpf())
                .withName(driverDTO.getName())
                .withAge(driverDTO.getAge())
                .withPhoneNumber(driverDTO.getPhoneNumber())
                .build();
    }

    public static DriverDomainEntityOutput mapToDriverDomainEntityOutput(DriverEntity driverEntity) {
        return new DriverDomainEntityOutputBuilder()
                .withExternalId(driverEntity.getExternalId())
                .withName(driverEntity.getName())
                .withAge(driverEntity.getAge())
                .withPhoneNumber(driverEntity.getPhoneNumber())
                .build();
    }

    public static List<DriverDomainEntityOutput> mapToDriverDomainEntitiesOutput(List<DriverEntity> driverEntities) {
        List<DriverDomainEntityOutput> outputs = new ArrayList<>();

        for (DriverEntity driverEntity : driverEntities) {
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

    public static DriverEntity mapToDriverEntity(DriverDomainEntityInput driverDomainEntityInput) {
        return new DriverEntityBuilder()
                .withCpf(driverDomainEntityInput.getCpf())
                .withName(driverDomainEntityInput.getName())
                .withAge(driverDomainEntityInput.getAge())
                .withPhoneNumber(driverDomainEntityInput.getPhoneNumber())
                .build();


    }
}
