package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.service.IInscriptionDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteSaveDriverUseCaseImpl implements IExecuteSaveDriverUseCase {

    private final IDriverDomainService personService;

    private final IInscriptionDomainService inscriptionService;

    public ExecuteSaveDriverUseCaseImpl(IDriverDomainService personService, IInscriptionDomainService inscriptionService) {
        this.personService = personService;
        this.inscriptionService = inscriptionService;
    }

    @Override
    public CustomData<DriverDomainEntityOutput> execute(DriverDomainEntityInput input) {

        final var driver = personService.createDriver(input);
        CustomData<DriverDomainEntityOutput> customData = new CustomData<>();
        customData.setData(driver);

//        inscriptionService.createInscription(driver);

        return customData;
    }
}
