package com.techchallenge.msdrivers.application.entrypoint.rest;


import com.techchallenge.msdrivers.application.entrypoint.rest.dto.PersonDTO;
import com.techchallenge.msdrivers.application.mapper.Mappers;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsCreatePersonUseCase;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsGetPersonUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final IExecuteArgsCreatePersonUseCase executeCreatePersonUseCase;

    private final IExecuteArgsGetPersonUseCase executeGetPersonUseCase;

    public PersonController(
            IExecuteArgsCreatePersonUseCase executeCreatePersonUseCase,
            IExecuteArgsGetPersonUseCase executeGetPersonUseCase) {
        this.executeCreatePersonUseCase = executeCreatePersonUseCase;
        this.executeGetPersonUseCase = executeGetPersonUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getPersons() {
        final var response = executeGetPersonUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonDTO personDTO) {

        final var personDomainEntity = Mappers.mapToPersonDomainEntityInput(personDTO);
        final var response = executeCreatePersonUseCase.execute(personDomainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
