package com.nicolavlad.dao;

import com.nicolavlad.domain.Employee;

public interface EmployeeDao extends AbstractDao<Employee> {

    void calculateTaxes(Employee employee);

}
