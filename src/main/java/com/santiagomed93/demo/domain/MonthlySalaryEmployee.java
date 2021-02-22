package com.santiagomed93.demo.domain;

import com.santiagomed93.demo.model.EmployeeClient;

public class MonthlySalaryEmployee extends Employee{

    private final static int MONTHS_IN_THE_YEAR = 12;

    @Override
    public double getAnnualSalary() {
        return MONTHS_IN_THE_YEAR * getMonthlySalary();
    }

    public MonthlySalaryEmployee(EmployeeClient employeeClient){
        setId(employeeClient.getId());
        setName(employeeClient.getName());
        setContractTypeName(employeeClient.getContractTypeName());
        setRoleId(employeeClient.getRoleId());
        setRoleName(employeeClient.getRoleName());
        setRoleDescription(employeeClient.getRoleDescription());
        setHourlySalary(employeeClient.getHourlySalary());
        setMonthlySalary(employeeClient.getMonthlySalary());
    }
}
