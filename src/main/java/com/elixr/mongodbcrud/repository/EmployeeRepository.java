package com.elixr.mongodbcrud.repository;

import com.elixr.mongodbcrud.bean.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmpId(BigInteger empId);

}
