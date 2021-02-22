package com.santiagomed93.demo.controller;

import com.santiagomed93.demo.domain.Employee;
import com.santiagomed93.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void testGetEmployeeList(){
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Employee>> response = employeeController.getEmployeeList();
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }
}
