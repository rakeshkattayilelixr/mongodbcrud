package com.elixr.mongodbcrud.service;

import com.elixr.mongodbcrud.bean.Employee;
import com.elixr.mongodbcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CRUDServiceImpl implements CRUDService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public String addEmployee(Employee employee) {
        Optional<Employee> check=employeeRepository.findByEmpId(employee.getEmpId());
        if (check.isPresent()){
            return "Already Exist";
        }
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public String updateEmployee(Employee employee) {
        Optional<Employee> check=employeeRepository.findByEmpId(employee.getEmpId());
        if (check.isEmpty()){
            return "Employee Id not found!!!";
        }
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public List<Employee> viewEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> deleteById(String empId) {
        employeeRepository.deleteById(empId);
        return employeeRepository.findAll();
    }
}
