package com.nicolavlad.dao;

import com.nicolavlad.domain.Employee;

import java.util.List;

public interface AbstractDao<T> {

    List<Employee> getAll();
    List<Employee> getById(int id);
    void deleteById(int id);
    void create(T c);

}
