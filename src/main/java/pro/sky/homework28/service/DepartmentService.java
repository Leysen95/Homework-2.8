package pro.sky.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.homework28.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class DepartmentService {
private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = new EmployeeService();
    }

    public Employee getMaxSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getAllEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
