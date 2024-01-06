package com.techchallenge.msdrivers.application.builder;


import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;

public class PersonDomainEntityInputBuilder {

    private final PersonDomainEntityInput personDomainEntityInput;

    public PersonDomainEntityInputBuilder() {
        personDomainEntityInput = new PersonDomainEntityInput();
    }

    public PersonDomainEntityInputBuilder withCpf(String cpf) {
        personDomainEntityInput.setCpf(cpf);
        return this;
    }

    public PersonDomainEntityInputBuilder withName(String name) {
        personDomainEntityInput.setName(name);
        return this;
    }

    public PersonDomainEntityInputBuilder withAge(int age) {
        personDomainEntityInput.setAge(age);
        return this;
    }

    public PersonDomainEntityInputBuilder withPhoneNumber(String phoneNumber) {
        personDomainEntityInput.setPhoneNumber(phoneNumber);
        return this;
    }

    public PersonDomainEntityInput build() {
        return personDomainEntityInput;
    }
}
