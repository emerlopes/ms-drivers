package com.techchallenge.msdrivers.domain.usecase;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteNoArgs;

import java.util.List;

public interface IExecuteArgsGetPersonUseCase extends IExecuteNoArgs<CustomData<List<PersonDomainEntityOutput>>> {
}
