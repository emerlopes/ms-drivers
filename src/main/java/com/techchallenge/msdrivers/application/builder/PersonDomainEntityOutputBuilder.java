package com.techchallenge.msdrivers.application.builder;


import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;

import java.util.UUID;

public class PersonDomainEntityOutputBuilder {

    private final PersonDomainEntityOutput personDomainEntityOutput;

    public PersonDomainEntityOutputBuilder() {
        personDomainEntityOutput = new PersonDomainEntityOutput();
    }

    public PersonDomainEntityOutputBuilder withExternalId(UUID externalId) {
        personDomainEntityOutput.setExternalId(externalId);
        return this;
    }

    public PersonDomainEntityOutputBuilder withName(String name) {
        personDomainEntityOutput.setName(name);
        return this;
    }

    public PersonDomainEntityOutputBuilder withAge(int age) {
        personDomainEntityOutput.setAge(age);
        return this;
    }

    public PersonDomainEntityOutputBuilder withPhoneNumber(String phoneNumber) {
        personDomainEntityOutput.setPhoneNumber(phoneNumber);
        return this;
    }

    public PersonDomainEntityOutput build() {
        return personDomainEntityOutput;
    }

}
