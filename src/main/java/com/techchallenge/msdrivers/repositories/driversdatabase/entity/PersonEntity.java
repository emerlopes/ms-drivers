package com.techchallenge.msdrivers.repositories.driversdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Index;

import java.util.UUID;

@Data
@Entity
@Table(name = "tb01_person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private Long internalId;

    @Column(name = "external_id")
    @Index(name = "idx_external_id")
    private UUID externalId;

    @Column(name = "cpf")
    @Index(name = "idx_cpf")
    private String cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    public PersonEntity() {
        this.externalId = UUID.randomUUID();
    }

}
