package com.bank.service;

import com.bank.dto.EmployeeDto;
import com.bank.exceptions.EmployeeNotFoundException;
import com.bank.model.Employee;
import com.bank.repository.EmployeeInformationRepository;
import com.bank.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeInformationRepository employeeInformationRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeInformationRepository employeeInformationRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeInformationRepository = employeeInformationRepository;
    }

    public Collection<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.getOne(id);
    }

    public Employee createEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setDepartment_id(employeeDto.getDepartment_id());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDto employeeDto){
        Employee employee = employeeRepository.getById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employee.setName(employeeDto.getName());
        employee.setDepartment_id(employeeDto.getDepartment_id());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
        employeeInformationRepository.deleteById(id);
    }

}
