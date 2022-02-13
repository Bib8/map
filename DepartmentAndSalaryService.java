package com.example.map;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentAndSalaryService implements DeparmentAndSalaryInterface {

    private final EmployeeServiceMap employeeServiceMap;


    public DepartmentAndSalaryService(EmployeeServiceMap employeeServiceMap) {
        this.employeeServiceMap = employeeServiceMap;
    }

    @Override
    public Employee maxSalaryInDeparmentId(int deparmentId) throws NotFoundAnyMatchException {
        return employeeServiceMap.getAllEmployees().stream().
                filter(e-> e.getDepartmentId() == deparmentId).
                max(Comparator.comparingInt(Employee::getSalary)).
                orElseThrow(NotFoundAnyMatchException::new);
    }

    @Override
    public Employee minSalaryInDeparmentId(int deparmentId) throws NotFoundAnyMatchException {
        return employeeServiceMap.getAllEmployees().stream().
                filter(e-> e.getDepartmentId() == deparmentId).
                min(Comparator.comparingInt(Employee::getSalary)).
                orElseThrow(NotFoundAnyMatchException::new);
    }

    @Override
    public Collection<Employee> findEmployeeInDeparmentId(int deparmentId) {
        return employeeServiceMap.getAllEmployees().stream().
                filter(e-> e.getDepartmentId() == deparmentId).
                collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeInDeparmentId() {
        return employeeServiceMap.getAllEmployees().stream().
                collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}

