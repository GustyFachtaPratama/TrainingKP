package com.example.cache.service;

import com.example.cache.entity.DeptEmployee;
import com.example.cache.repo.DeptEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptEmployeeService {

    @Autowired
    private DeptEmployeeRepository deptEmployeeRepository;

    public List<DeptEmployee> findEmployeesByDepartmentName(String deptName) {
        return deptEmployeeRepository.findEmployeesByDepartmentName(deptName);
    }

    public List<DeptEmployee> findEmployeesByTitle(String designation) {
        return deptEmployeeRepository.findEmployeesByTitle(designation);
    }

    public List<DeptEmployee> empId(String designation) {
        return deptEmployeeRepository.findDepartmentOfAnEmployee(designation);
    }

}
