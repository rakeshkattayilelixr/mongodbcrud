package com.elixr.mongodbcrud.controller;

import com.elixr.mongodbcrud.bean.Employee;
import com.elixr.mongodbcrud.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class CRUDController {

    @Autowired
    CRUDService crudService;

    @PostMapping("/add")
    public ResponseEntity<String> insertData(@RequestBody Employee employee) {
        String msg=crudService.addEmployee(employee);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateData(@RequestBody Employee employee) {
        String msg=crudService.updateEmployee(employee);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Employee>> viewData() {
        List<Employee> employees=crudService.viewEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<List<Employee>> deleteData(@PathVariable String empId) {
        List<Employee> employees=crudService.deleteById(empId);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }


}
