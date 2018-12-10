package com.nicolavlad.service;

import com.nicolavlad.dao.EmployeeDao;
import com.nicolavlad.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Qualifier("employeeDao")
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeDao.create(employee);
    }

    @Override
    public void calculateTaxes(Employee employee) {
        employeeDao.calculateTaxes(employee);
    }

}
