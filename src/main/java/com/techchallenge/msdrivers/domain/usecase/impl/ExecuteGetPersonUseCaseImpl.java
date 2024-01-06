package com.techchallenge.msdrivers.domain.usecase.impl;


import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IPersonDomainService;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsGetPersonUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteGetPersonUseCaseImpl implements IExecuteArgsGetPersonUseCase {

    private final IPersonDomainService personService;

    public ExecuteGetPersonUseCaseImpl(IPersonDomainService personService) {
        this.personService = personService;
    }

    @Override
    public CustomData<List<PersonDomainEntityOutput>> execute() {
        final var persons = personService.getPersons();
        CustomData<List<PersonDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(persons);
        return customData;
    }


}
