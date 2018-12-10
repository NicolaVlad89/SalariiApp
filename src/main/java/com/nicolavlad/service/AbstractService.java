package com.nicolavlad.service;

import java.util.List;

public interface AbstractService<T> {

    List<T> getAll();
    List<T> getById(int id);
    void deleteById(int id);
    void create(T c);
}
