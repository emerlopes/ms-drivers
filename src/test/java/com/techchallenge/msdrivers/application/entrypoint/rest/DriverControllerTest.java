package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindAllDriversUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class DriverControllerTest {

    @Mock
    private IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase;

    @Mock
    private IExecuteFindAllDriversUseCase iExecuteFindAllDriversUseCase;

    @Mock
    private IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase;

    @InjectMocks
    private DriverController driverController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(driverController).build();
    }

    @Test
    public void testFindDriverById() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(get("/api/drivers/" + id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveDriver() throws Exception {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setCpf("30030030030");
        driverDTO.setName("Test");
        driverDTO.setAge(30);
        driverDTO.setPhoneNumber("1234567890");
        driverDTO.setAddress("Test address");

        mockMvc.perform(post("/api/drivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(driverDTO)))
                .andExpect(status().isCreated());
    }
}