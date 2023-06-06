package org.example.service;

import java.util.List;

public interface GenericService<T> {
    void create(T entity);
    T getById(int id);
    void update(T entity);
    void delete(int id);
    List<T> getAll();
}
