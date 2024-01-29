package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementação do caso de uso para buscar um motorista por ID externo.
 *
 * Este caso de uso é responsável por receber o ID externo do motorista como entrada,
 * buscar o motorista correspondente com base nesse ID e retornar os dados do motorista encontrado.
 */
@Service
public class IExecuteFindDriverByIdUseCaseImpl implements IExecuteFindDriverByIdUseCase {

    private final IDriverDomainService driverDomainService;

    /**
     * Construtor da classe IExecuteFindDriverByIdUseCaseImpl.
     *
     * @param driverDomainService Serviço de domínio relacionado a motoristas.
     */
    public IExecuteFindDriverByIdUseCaseImpl(IDriverDomainService driverDomainService) {
        this.driverDomainService = driverDomainService;
    }

    /**
     * Executa o caso de uso para buscar um motorista por ID externo.
     *
     * @param externalDriverId ID externo do motorista a ser buscado.
     * @return CustomData com DriverEntity contendo os dados do motorista encontrado.
     *         Se nenhum motorista for encontrado com o ID externo fornecido, o campo de dados estará nulo.
     */
    @Override
    public CustomData<DriverEntity> execute(UUID externalDriverId) {
        final var driver = driverDomainService.getDriverByExternalId(externalDriverId);
        CustomData<DriverEntity> customData = new CustomData<>();
        customData.setData(driver);
        return customData;
    }
}
