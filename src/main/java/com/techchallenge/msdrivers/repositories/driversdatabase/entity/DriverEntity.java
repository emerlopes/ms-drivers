package com.techchallenge.msdrivers.repositories.driversdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Index;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb01_person")
public class DriverEntity {

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<VehicleEntity> vehicles;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DriverEntity() {
        this.externalId = UUID.randomUUID();
    }

}
