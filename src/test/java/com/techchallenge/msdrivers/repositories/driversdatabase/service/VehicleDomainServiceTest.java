package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IVehicleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VehicleDomainServiceTest {

    @InjectMocks
    private VehicleDomainService vehicleDomainService;

    @Mock
    private IVehicleRepository vehicleRepository;

    @Mock
    private IDriverRepository driverRepository;

    @Test
    public void testCreateVehicle() {
        // Crie um objeto VehicleDomainEntityInput simulado
        VehicleDomainEntityInput input = new VehicleDomainEntityInput(/* Preencha com dados simulados */);

        // Crie um objeto DriverEntity simulado
        DriverEntity driverEntity = new DriverEntity(/* Preencha com dados simulados */);

        // Crie um objeto VehicleEntity simulado
        VehicleEntity vehicleEntity = new VehicleEntity(/* Preencha com dados simulados */);
        vehicleEntity.setDriver(driverEntity);

        // Defina o comportamento do mock para vehicleRepository
        when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(vehicleEntity);

        // Execute o método createVehicle() do serviço de domínio
        VehicleDomainEntityOutput result = vehicleDomainService.createVehicle(input);

        // Verifique se o resultado contém os dados simulados do veículo criado
        assertEquals(vehicleEntity.getVehicleId(), result.getVehicleId());

        // Verifique se o método save foi chamado no repositório de veículos
        verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));

        // Verifique se o método save foi chamado no repositório de motoristas
        verify(driverRepository, times(1)).save(driverEntity);
    }
}