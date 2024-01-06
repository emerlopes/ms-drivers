package com.techchallenge.msdrivers.repositories.driversdatabase.repository;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {
}
