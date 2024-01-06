package com.techchallenge.msdrivers.domain.service;


import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;

import java.util.List;

public interface IPersonDomainService {
    PersonDomainEntityOutput createPerson(PersonDomainEntityInput personDomainEntityInput);

    List<PersonDomainEntityOutput> getPersons();


}
