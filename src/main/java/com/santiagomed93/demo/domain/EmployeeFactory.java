package com.santiagomed93.demo.domain;

import com.santiagomed93.demo.model.EmployeeClient;

public class EmployeeFactory {

    public static Employee getInstance(EmployeeClient employeeClient){
        Employee employeeResponse;
        String typeOfContract = employeeClient.getContractTypeName();
        if(typeOfContract == null){
            return null;
        }
        switch (typeOfContract) {
            case "HourlySalaryEmployee":
                employeeResponse = new HourlySalaryEmployee(employeeClient);
                break;
            case "MonthlySalaryEmployee":
                employeeResponse = new MonthlySalaryEmployee(employeeClient);
                break;
            default:
                employeeResponse = null;
                break;
        }
        return employeeResponse;
    }
}
