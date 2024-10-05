package pro.sky.homework28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework28.employee.Employee;
import pro.sky.homework28.service.EmployeeService;

import java.util.Collection;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int departmentId,
                                @RequestParam double salary) {
        return employeeService.addEmployee(firstName,lastName,departmentId,salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int departmentId,
                                   @RequestParam double salary) {
        return employeeService.removeEmployee(firstName,lastName,departmentId,salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int departmentId,
                                 @RequestParam double salary) {
        return employeeService.findEmployee(firstName,lastName,departmentId,salary);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
