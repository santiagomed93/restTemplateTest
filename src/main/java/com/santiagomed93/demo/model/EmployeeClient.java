package com.santiagomed93.demo.model;

import lombok.Data;

@Data
public class EmployeeClient {
    private Long id;
    private String name;
    private String contractTypeName;
    private Long roleId;
    private String roleName;
    private String roleDescription;
    private double hourlySalary;
    private double monthlySalary;
    private double annualSalary;
}
