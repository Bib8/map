package com.example.map;

public interface EmployeeServiceInterface {
    String addToRepositoryEmployee(Employee employee);
    String removeFromRepositoryEmployee(Employee employee);
    String findEmployeeInRepository(Employee employee);
}