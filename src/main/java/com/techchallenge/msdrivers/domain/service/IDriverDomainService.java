package com.techchallenge.msdrivers.domain.service;


import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityOutput;

import java.util.List;

public interface IPersonDomainService {
    PersonDomainEntityOutput createPerson(PersonDomainEntityInput personDomainEntityInput);

    List<PersonDomainEntityOutput> getPersons();


}
