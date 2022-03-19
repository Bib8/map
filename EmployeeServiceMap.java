package com.example.map;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.*;
import org.springframework.util.NumberUtils;

import java.util.*;
//сервис мапов!!!!!!!
@Service
public class EmployeeServiceMap implements EmployeeMapInterface{

    private final Map<String, Employee> employeesMap = new HashMap<>();

    @Override
    public Employee addToRepositoryEmployee(String firstname, String lastname) {
        Employee addEmpoyee = new Employee(firstname, lastname);
        String key = firstname + lastname;
        if (StringUtils.isEmpty(key) || NumberUtils.STANDARD_NUMBER_TYPES.contains(key)
        ) {
            throw new NullPointerException("error");
        }
        employeesMap.put(key, addEmpoyee);
        return  addEmpoyee;
    }

    @Override
    public Employee removeFromRepositoryEmployee(String firstname, String lastname) throws NotFoundAnyMatchException {
        String key = firstname + lastname;
        if (StringUtils.isEmpty(key)) {
            throw new NullPointerException("error");
        }else if (!StringUtils.containsOnly(key)) {
            throw new NotFoundAnyMatchException("Error - not found");
        }
        return employeesMap.remove(key);
    }

    @Override
    public Employee findEmployeeInRepository(String firstname, String lastname) throws NotFoundAnyMatchException {

        String key = firstname + lastname;
        if (!StringUtils.containsOnly(key)) {
            throw new NotFoundAnyMatchException("Error - not found");
        }
        return employeesMap.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }


}
