package com.santiagomed93.demo.service;

import com.santiagomed93.demo.model.EmployeeClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="employees", url="http://masglobaltestapi.azurewebsites.net/api/employees")
public interface EmployeeService {

    @GetMapping()
    List<EmployeeClient> findAll();
}
