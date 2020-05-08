package com.bank.controller;

import com.bank.model.Department;
import com.bank.model.Employee;
import com.bank.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public Collection<Employee> employees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    ResponseEntity<?> getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/employees")
    ResponseEntity<Employee> createEmployee(Long departmentId, @Valid @RequestBody Employee employee) throws URISyntaxException {
        return service.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }

    @GetMapping("/employees/department/{id}")
    public Collection<Employee> getEmployeesByDepartmentId(@PathVariable Department id){
        return service.getEmployeesByDepartmentId(id);
    }

    @GetMapping("/employees/sortedbysalary=asc")
    public Collection<Employee> getSortedEmployeesBySalary(){
        return service.getSortedEmployeesBySalary();
    }
    @GetMapping("/employees/sortedbysalary=desc")
    public Collection<Employee> getSortedEmployeesBySalaryDesc(){
        return service.getSortedEmployeesBySalaryDesc();
    }
}
