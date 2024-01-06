package com.techchallenge.msdrivers.domain.shared;

public interface IExecuteArgs<T, J> {
    T execute(J domainObject);
}
