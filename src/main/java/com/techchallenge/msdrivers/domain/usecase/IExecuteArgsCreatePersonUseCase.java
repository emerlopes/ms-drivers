package com.techchallenge.msdrivers.domain.usecase;


import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteArgs;

public interface IExecuteArgsCreatePersonUseCase extends IExecuteArgs<CustomData<PersonDomainEntityOutput>, PersonDomainEntityInput> {
}
