package com.example.map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DeparmentAndSalaryController {
    private final DepartmentAndSalaryService departmentAndSalaryService;

    public DeparmentAndSalaryController(DepartmentAndSalaryService departmentAndSalaryService) {
        this.departmentAndSalaryService = departmentAndSalaryService;
    }
    @GetMapping("/maxSalary")
    public Employee maxSalaryInDeparmentId(@RequestParam int deparmentId) throws NotFoundAnyMatchException {
        return departmentAndSalaryService.maxSalaryInDeparmentId(deparmentId);
    }
    @GetMapping("/minSalary")
    public Employee minSalaryInDeparmentId(@RequestParam int deparmentId) throws NotFoundAnyMatchException {
        return departmentAndSalaryService.minSalaryInDeparmentId(deparmentId);
    }
    @GetMapping(path ="/find", params = {"deparmetnId"})
    public Collection<Employee> findEmployeeInDeparmentId(@RequestParam int deparmentId) {
        return departmentAndSalaryService.findEmployeeInDeparmentId(deparmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployeeInDeparmentId() {
        return departmentAndSalaryService.allEmployeeInDeparmentId();
    }


}

