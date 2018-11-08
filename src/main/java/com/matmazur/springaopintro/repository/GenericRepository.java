package com.matmazur.springaopintro.repository;

public interface GenericRepository<I, P> {

    P getById(I id);
    void add(P p);
}
