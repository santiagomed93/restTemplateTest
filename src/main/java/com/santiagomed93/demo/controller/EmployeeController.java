package com.santiagomed93.demo.controller;

import com.santiagomed93.demo.controllerAdvice.exceptionType.BadRequestException;
import com.santiagomed93.demo.domain.Employee;
import com.santiagomed93.demo.domain.EmployeeFactory;
import com.santiagomed93.demo.model.EmployeeClient;
import com.santiagomed93.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<List<Employee>> getEmployeeList(){
        List<EmployeeClient> employeeClientList = employeeService.findAll();
        List<Employee> employeeList = employeeClientList.stream()
                .map(EmployeeFactory::getInstance)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws BadRequestException {
        EmployeeClient employeeClient = employeeService.findAll().stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getId().equals(id))
                .findAny().orElseThrow(() -> new BadRequestException("employee not found"));
        Employee employee = EmployeeFactory.getInstance(employeeClient);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
