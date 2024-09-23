package com.example.cache.repo;

import com.example.cache.entity.DeptEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptEmployeeRepository extends JpaRepository<DeptEmployee, Long> {

    @Query("SELECT e FROM DeptEmployee e JOIN e.department d WHERE d.name = :deptName")
    public List<DeptEmployee> findEmployeesByDepartmentName(@Param("deptName") String deptName);

    @Query("SELECT e FROM DeptEmployee e where e.title = :designation")
    public List<DeptEmployee> findEmployeesByTitle(@Param("designation") String designation);

    @Query("SELECT e.department FROM DeptEmployee e JOIN e.department WHERE e.employeeNumber = :empId")
    public List<DeptEmployee> findDepartmentOfAnEmployee(@Param("empId") String empId);
}
