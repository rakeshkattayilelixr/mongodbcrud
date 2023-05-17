package com.elixr.mongodbcrud.service;

import com.elixr.mongodbcrud.bean.Employee;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

public interface CRUDService {
    public String addEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    List<Employee> viewEmployees();

    List<Employee> deleteById(String empId);
}
