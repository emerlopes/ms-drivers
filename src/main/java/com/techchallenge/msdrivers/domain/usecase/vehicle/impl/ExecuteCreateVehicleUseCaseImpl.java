package com.techchallenge.msdrivers.domain.usecase.vehicle.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IVehicleDomainService;
import com.techchallenge.msdrivers.domain.usecase.vehicle.IExecuteCreateVehicleUseCase;
import org.springframework.stereotype.Service;

/**
 * Implementação do caso de uso para criar um novo veículo.
 */
@Service
public class ExecuteCreateVehicleUseCaseImpl implements IExecuteCreateVehicleUseCase {

    private final IVehicleDomainService vehicleDomainService;

    /**
     * Construtor da classe ExecuteCreateVehicleUseCaseImpl.
     *
     * @param vehicleDomainService Serviço de domínio relacionado a veículos.
     */
    public ExecuteCreateVehicleUseCaseImpl(IVehicleDomainService vehicleDomainService) {
        this.vehicleDomainService = vehicleDomainService;
    }

    /**
     * Executa o caso de uso para criar um novo veículo.
     *
     * @param vehicleDomainEntityInput Parâmetro de entrada contendo dados do veículo a ser criado.
     * @return CustomData com VehicleDomainEntityOutput contendo o veículo criado.
     */
    @Override
    public CustomData<VehicleDomainEntityOutput> execute(VehicleDomainEntityInput vehicleDomainEntityInput) {
        final var vehicle = vehicleDomainService.createVehicle(vehicleDomainEntityInput);
        CustomData<VehicleDomainEntityOutput> customData = new CustomData<>();
        customData.setData(vehicle);
        return customData;
    }
}
