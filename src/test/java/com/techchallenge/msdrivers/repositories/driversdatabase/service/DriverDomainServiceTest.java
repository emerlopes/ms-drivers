package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DriverDomainServiceTest {

    @InjectMocks
    private DriverDomainService driverDomainService;

    @Mock
    private IDriverRepository driverRepository;

    @Test
    public void testCreateDriver() {
        // Crie um objeto DriverDomainEntityInput simulado
        DriverDomainEntityInput input = new DriverDomainEntityInput(/* Preencha com dados simulados */);

        // Crie um objeto DriverEntity simulado
        DriverEntity entity = new DriverEntity();
        entity.setExternalId(UUID.randomUUID());
        entity.setName("John Doe");

        // Defina o comportamento do mock para driverRepository
        when(driverRepository.save(any(DriverEntity.class))).thenReturn(entity);

        // Execute o método createDriver() do serviço de domínio
        DriverDomainEntityOutput result = driverDomainService.createDriver(input);

        // Verifique se o resultado contém os dados simulados do motorista criado
        assertEquals(entity.getName(), result.getName());

        // Verifique se o método save foi chamado no repositório
        verify(driverRepository, times(1)).save(any(DriverEntity.class));
    }

    @Test
    public void testFindAllDrivers() {
        // Crie uma lista simulada de DriverEntity
        List<DriverEntity> entityList = new ArrayList<>();
        entityList.add(new DriverEntity(/* Preencha com dados simulados */));

        // Defina o comportamento do mock para driverRepository
        when(driverRepository.findAll()).thenReturn(entityList);

        // Execute o método findAllDrivers() do serviço de domínio
        List<DriverDomainEntityOutput> result = driverDomainService.findAllDrivers();

        // Verifique se o resultado contém a lista simulada de motoristas
        assertEquals(entityList.size(), result.size());

        // Verifique se o método findAll foi chamado no repositório
        verify(driverRepository, times(1)).findAll();
    }

    @Test
    public void testFindDriverByExternalId() {
        UUID externalDriverId = UUID.randomUUID();
        // Crie um objeto DriverEntity simulado
        DriverEntity entity = new DriverEntity(/* Preencha com dados simulados */);

        // Defina o comportamento do mock para driverRepository
        when(driverRepository.findByExternalId(externalDriverId)).thenReturn(entity);

        // Execute o método findDriverByExternalId() do serviço de domínio
        DriverDomainEntityOutput result = driverDomainService.findDriverByExternalId(externalDriverId);

        // Verifique se o resultado contém os dados simulados do motorista encontrado
        assertEquals(entity.getName(), result.getName());

        // Verifique se o método findByExternalId foi chamado no repositório com o ID externo correto
        verify(driverRepository, times(1)).findByExternalId(externalDriverId);
    }

    @Test
    public void testGetDriverByExternalIdWithDriverFound() {
        UUID externalDriverId = UUID.randomUUID();
        // Crie um objeto DriverEntity simulado
        DriverEntity entity = new DriverEntity(/* Preencha com dados simulados */);

        // Defina o comportamento do mock para driverRepository
        when(driverRepository.findByExternalId(externalDriverId)).thenReturn(entity);

        // Execute o método getDriverByExternalId() do serviço de domínio
        DriverEntity result = driverDomainService.getDriverByExternalId(externalDriverId);

        // Verifique se o resultado contém os dados simulados do motorista encontrado
        assertEquals(entity.getName(), result.getName());

        // Verifique se o método findByExternalId foi chamado no repositório com o ID externo correto
        verify(driverRepository, times(1)).findByExternalId(externalDriverId);
    }

    @Test
    public void testGetDriverByExternalIdWithNoDriverFound() {
        UUID externalDriverId = UUID.randomUUID();
        // Defina o comportamento do mock para driverRepository retornando null
        when(driverRepository.findByExternalId(externalDriverId)).thenReturn(null);

        // Execute o método getDriverByExternalId() do serviço de domínio
        DriverEntity result = driverDomainService.getDriverByExternalId(externalDriverId);

        // Verifique se o resultado é nulo (nenhum motorista encontrado)
        assertEquals(null, result);

        // Verifique se o método findByExternalId foi chamado no repositório com o ID externo correto
        verify(driverRepository, times(1)).findByExternalId(externalDriverId);
    }

}