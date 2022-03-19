package com.example.map;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    @Override
    public String addToRepositoryEmployee(Employee employee) {
        employees.add(employee);
        return "added";
    }

    @Override
    public String removeFromRepositoryEmployee(Employee employee) {
        employees.remove(employee);
        return "removed";
    }

    @Override
    public String findEmployeeInRepository(Employee employee) {
        int id = employees.indexOf(employee);
        return String.join(" ", "Founded - " + id);
    }

    public List<String> printRepository() {
        List<String> listOfEmployees = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            String result = String.join(" ", employee.getFirstName(), employee.getLastName());
            listOfEmployees.add(result);
        }
        return listOfEmployees;
    }

//String result = String.join(" ", listOfEmployees.add(employee.getFirstName())  + listOfEmployees.add(employee.getLastName()));
}
