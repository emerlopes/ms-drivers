package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindAllDriversUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do caso de uso para buscar todos os motoristas.
 *
 * Este caso de uso é responsável por recuperar uma lista de todos os motoristas registrados no sistema.
 */
@Service
public class ExecuteFindAllDriversUseCaseImpl implements IExecuteFindAllDriversUseCase {

    private final IDriverDomainService driverDomainService;

    /**
     * Construtor da classe ExecuteFindAllDriversUseCaseImpl.
     *
     * @param driverDomainService Serviço de domínio relacionado a motoristas.
     */
    public ExecuteFindAllDriversUseCaseImpl(IDriverDomainService driverDomainService) {
        this.driverDomainService = driverDomainService;
    }

    /**
     * Executa o caso de uso para buscar todos os motoristas.
     *
     * @return CustomData contendo uma lista de DriverDomainEntityOutput com todos os motoristas encontrados.
     *         A lista pode estar vazia se nenhum motorista for encontrado.
     */
    @Override
    public CustomData<List<DriverDomainEntityOutput>> execute() {
        final var drivers = driverDomainService.findAllDrivers();
        CustomData<List<DriverDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(drivers);
        return customData;
    }
}
