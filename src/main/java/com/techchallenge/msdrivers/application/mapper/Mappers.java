package com.techchallenge.msdrivers.application.mapper;



import com.techchallenge.msdrivers.application.builder.PersonDomainEntityInputBuilder;
import com.techchallenge.msdrivers.application.builder.PersonDomainEntityOutputBuilder;
import com.techchallenge.msdrivers.application.builder.PersonEntityBuilder;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.PersonDTO;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class Mappers {
    public static PersonDomainEntityInput mapToPersonDomainEntityInput(PersonDTO personDTO) {
        return new PersonDomainEntityInputBuilder()
                .withCpf(personDTO.getCpf())
                .withName(personDTO.getName())
                .withAge(personDTO.getAge())
                .withPhoneNumber(personDTO.getPhoneNumber())
                .build();
    }

    public static PersonDomainEntityOutput mapToPersonDomainEntityOutput(PersonEntity personEntity) {
        return new PersonDomainEntityOutputBuilder()
                .withExternalId(personEntity.getExternalId())
                .withName(personEntity.getName())
                .withAge(personEntity.getAge())
                .withPhoneNumber(personEntity.getPhoneNumber())
                .build();
    }

    public static List<PersonDomainEntityOutput> mapToPersonDomainEntitiesOutput(List<PersonEntity> personEntities) {
        List<PersonDomainEntityOutput> outputs = new ArrayList<>();

        for (PersonEntity personEntity : personEntities) {
            final var output = new PersonDomainEntityOutputBuilder()
                    .withExternalId(personEntity.getExternalId())
                    .withName(personEntity.getName())
                    .withAge(personEntity.getAge())
                    .withPhoneNumber(personEntity.getPhoneNumber())
                    .build();

            outputs.add(output);
        }

        return outputs;
    }

    public static PersonEntity mapToPersonEntity(PersonDomainEntityInput personDomainEntityInput) {
        return new PersonEntityBuilder()
                .withCpf(personDomainEntityInput.getCpf())
                .withName(personDomainEntityInput.getName())
                .withAge(personDomainEntityInput.getAge())
                .withPhoneNumber(personDomainEntityInput.getPhoneNumber())
                .build();


    }
}
