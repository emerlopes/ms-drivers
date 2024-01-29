package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import org.springframework.stereotype.Service;

/**
 * Implementação do caso de uso para salvar um novo motorista.
 *
 * Este caso de uso é responsável por receber os dados de entrada do motorista,
 * criar um novo motorista com base nesses dados e retornar os dados do motorista criado.
 */
@Service
public class ExecuteSaveDriverUseCaseImpl implements IExecuteSaveDriverUseCase {

    private final IDriverDomainService personService;

    /**
     * Construtor da classe ExecuteSaveDriverUseCaseImpl.
     *
     * @param personService Serviço de domínio relacionado a motoristas.
     */
    public ExecuteSaveDriverUseCaseImpl(IDriverDomainService personService) {
        this.personService = personService;
    }

    /**
     * Executa o caso de uso para salvar um novo motorista.
     *
     * @param input Parâmetro de entrada contendo os dados do novo motorista a ser criado.
     * @return CustomData com DriverDomainEntityOutput contendo os dados do motorista criado.
     */
    @Override
    public CustomData<DriverDomainEntityOutput> execute(DriverDomainEntityInput input) {
        final var driver = personService.createDriver(input);
        CustomData<DriverDomainEntityOutput> customData = new CustomData<>();
        customData.setData(driver);
        return customData;
    }
}
