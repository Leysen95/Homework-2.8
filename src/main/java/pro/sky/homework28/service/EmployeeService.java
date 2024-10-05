package pro.sky.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.homework28.employee.Employee;
import pro.sky.homework28.exception.EmployeeAlreadyAddedException;
import pro.sky.homework28.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName, int departmentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, int departmentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName, int departmentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    public Arrays findAll() {
        return null;
    }
}
