package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private List<EmployeeDto> employeeList;
}
