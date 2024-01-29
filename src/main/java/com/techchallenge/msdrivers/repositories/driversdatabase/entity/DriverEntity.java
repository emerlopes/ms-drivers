package com.techchallenge.msdrivers.repositories.driversdatabase.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Index;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "tb01_driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_driver_id")
    private Long internalId;

    @Column(name = "external_driver_id")
    @Index(name = "idx_external_driver_id")
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

    @Column(name = "address")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleEntity> vehicles;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DriverEntity() {
        this.externalId = UUID.randomUUID();
    }

}
