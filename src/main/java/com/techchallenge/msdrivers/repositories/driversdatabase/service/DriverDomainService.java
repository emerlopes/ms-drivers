package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementação do serviço de domínio relacionado a motoristas.
 */
@Service
public class DriverDomainService implements IDriverDomainService {

    private final IDriverRepository driverRepository;

    /**
     * Construtor da classe DriverDomainService.
     *
     * @param driverRepository Repositório de motoristas.
     */
    public DriverDomainService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /**
     * Cria um novo motorista com base nos dados de entrada.
     *
     * @param driverDomainEntityInput Parâmetro de entrada contendo os dados do novo motorista a ser criado.
     * @return DriverDomainEntityOutput com os dados do motorista criado.
     */
    @Override
    public DriverDomainEntityOutput createDriver(DriverDomainEntityInput driverDomainEntityInput) {
        final var entity = DriverMappers.mapToDriverEntity(driverDomainEntityInput);
        final var personEntity = driverRepository.save(entity);

        return DriverMappers.mapToDriverDomainEntityOutput(personEntity);
    }

    /**
     * Busca todos os motoristas registrados no sistema.
     *
     * @return Lista de DriverDomainEntityOutput contendo todos os motoristas encontrados.
     */
    @Override
    public List<DriverDomainEntityOutput> findAllDrivers() {
        final var entities = driverRepository.findAll();
        return DriverMappers.mapToDriverDomainEntitiesOutput(entities);
    }

    /**
     * Busca um motorista pelo seu ID externo.
     *
     * @param driverExternalId ID externo do motorista a ser buscado.
     * @return DriverDomainEntityOutput com os dados do motorista encontrado.
     */
    @Override
    public DriverDomainEntityOutput findDriverByExternalId(UUID driverExternalId) {
        final var driver = driverRepository.findByExternalId(driverExternalId);
        return DriverMappers.mapToDriverDomainEntityOutput(driver);
    }

    /**
     * Obtém um motorista pelo seu ID externo.
     *
     * @param id ID externo do motorista a ser obtido.
     * @return DriverEntity com os dados do motorista encontrado ou nulo se nenhum motorista for encontrado com o ID externo fornecido.
     */
    @Override
    public DriverEntity getDriverByExternalId(UUID id) {
        return driverRepository.findByExternalId(id);
    }
}
