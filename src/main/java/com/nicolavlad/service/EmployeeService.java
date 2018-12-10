package com.nicolavlad.service;

import com.nicolavlad.domain.Employee;

public interface EmployeeService extends AbstractService<Employee> {

    void calculateTaxes(Employee employee);

}
