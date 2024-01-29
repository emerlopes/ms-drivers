package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.application.mapper.vehicle.VehicleMappers;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IVehicleDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

/**
 * Implementação do serviço de domínio relacionado a veículos.
 */
@Service
public class VehicleDomainService implements IVehicleDomainService {

    private final IVehicleRepository vehicleRepository;
    private final IDriverRepository driverRepository;

    /**
     * Construtor da classe VehicleDomainService.
     *
     * @param vehicleRepository Repositório de veículos.
     * @param driverRepository  Repositório de motoristas.
     */
    public VehicleDomainService(IVehicleRepository vehicleRepository, IDriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    /**
     * Cria um novo veículo com base nos dados de entrada.
     *
     * @param vehicleDomainEntityInput Parâmetro de entrada contendo dados do veículo a ser criado.
     * @return VehicleDomainEntityOutput com o veículo criado.
     */
    @Override
    public VehicleDomainEntityOutput createVehicle(VehicleDomainEntityInput vehicleDomainEntityInput) {
        final var vehicleEntity = VehicleMappers.mapToVehileEntity(vehicleDomainEntityInput);
        final var entitySaved = vehicleRepository.save(vehicleEntity);
        final var driver = entitySaved.getDriver();

        driverRepository.save(driver);

        return VehicleMappers.mapToVechileDomainEntityOutput(entitySaved);
    }
}