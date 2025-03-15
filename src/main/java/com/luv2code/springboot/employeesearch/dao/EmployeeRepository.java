package com.luv2code.springboot.employeesearch.dao;

import com.luv2code.springboot.employeesearch.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
