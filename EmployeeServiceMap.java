package com.example.map;

import org.springframework.stereotype.Service;

import java.util.*;
//сервис мапов!!!!!!!
@Service
public class EmployeeServiceMap implements EmployeeMapInterface{

    private final Map<String, Employee> employeesMap = new HashMap<>();

    @Override
    public Employee addToRepositoryEmployee(String firstname, String lastname) throws NotFoundAnyMatchException {
        Employee addEmpoyee = new Employee(firstname, lastname);
        String key = firstname + lastname;
        if (!employeesMap.containsKey(firstname + lastname)) {
            throw new NotFoundAnyMatchException("Error - not found");
        }
        employeesMap.put(key, addEmpoyee);
        return  addEmpoyee;
    }

    @Override
    public Employee removeFromRepositoryEmployee(String firstname, String lastname) throws NotFoundAnyMatchException {
        String key = firstname + lastname;
        if (!employeesMap.containsKey(firstname + lastname)) {
            throw new NotFoundAnyMatchException("Error - not found");
        }
        return employeesMap.remove(key);
    }

    @Override
    public Employee findEmployeeInRepository(String firstname, String lastname) throws NotFoundAnyMatchException {

        String key = firstname + lastname;
        if (!employeesMap.containsKey(key)) {
            throw new NotFoundAnyMatchException("Error - not found");
        }
        return employeesMap.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }


}
