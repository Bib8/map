package com.example.map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/post/add")
    public String addEmployee(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.addToRepositoryEmployee(employee);
    }
    @GetMapping(path="/get/remove")
    public String removeEmployee(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.removeFromRepositoryEmployee(employee);
    }
    @GetMapping(path="/get/search")
    public String findEmployee(@RequestParam("firstName") String firstname, @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.findEmployeeInRepository(employee);
    }
    @GetMapping(path = "/get/rep")
    @RequestMapping(value = "/get/rep" , method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> printService() {
        return employeeService.printRepository();
    }
}
