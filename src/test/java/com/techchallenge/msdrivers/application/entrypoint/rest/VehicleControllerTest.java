package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.vehicle.IExecuteCreateVehicleUseCase;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class VehicleControllerTest {

    @Mock
    private IExecuteCreateVehicleUseCase executeCreateVehicleUseCase;

    @Mock
    private IExecuteFindDriverByIdUseCase executeGetDriverUseCase;

    @InjectMocks
    private VehicleController vehicleController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }
    
    public void testCreateVehicle() throws Exception {
        VehicleDTO vehicleDTO = new VehicleDTO();
        UUID driverExternalId = UUID.randomUUID();
        vehicleDTO.setDriverExternalId(driverExternalId);
        vehicleDTO.setLicensePlateNumber("ABC-1234");
        vehicleDTO.setModel("Test Model");

        // Mock the driver
        CustomData<DriverEntity> driver = new CustomData<>();
        driver.setData(driver.getData());
        when(executeGetDriverUseCase.execute(driverExternalId)).thenReturn(driver);

        mockMvc.perform(post("/api/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(vehicleDTO)))
                .andExpect(status().isCreated());
    }
}