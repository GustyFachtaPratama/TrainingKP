package com.example.cache.controller;

import com.example.cache.entity.DeptEmployee;
import com.example.cache.service.DeptEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class DeptEmployeeController {

    @Autowired
    private DeptEmployeeService deptEmployeeService;

    @GetMapping("/by-department/{deptName}")
    public List<DeptEmployee> getEmployeesByDepartment(@PathVariable String deptName) {
        return deptEmployeeService.findEmployeesByDepartmentName(deptName);
    }

    @GetMapping("/by-title/{designation}")
    public List<DeptEmployee> getEmployeesByTitle(@PathVariable String designation) {
        return deptEmployeeService.findEmployeesByTitle(designation);
    }

    @GetMapping("/by-employee/{empId}")
    public List<DeptEmployee> findDepartmentOfAnEmployee(@PathVariable String empId) {
        return deptEmployeeService.findEmployeesByTitle(empId);
    }

}
