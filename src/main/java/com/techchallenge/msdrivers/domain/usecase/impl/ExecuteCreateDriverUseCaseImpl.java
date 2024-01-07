package com.techchallenge.msdrivers.domain.usecase.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IPersonDomainService;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsCreatePersonUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteCreatePersonUseCaseImpl implements IExecuteArgsCreatePersonUseCase {

    private final IPersonDomainService personService;

    public ExecuteCreatePersonUseCaseImpl(IPersonDomainService personService) {
        this.personService = personService;
    }

    @Override
    public CustomData<PersonDomainEntityOutput> execute(PersonDomainEntityInput personDomainEntityInput) {

        final var person = personService.createPerson(personDomainEntityInput);
        CustomData<PersonDomainEntityOutput> customData = new CustomData<>();
        customData.setData(person);
        return customData;
    }
}
