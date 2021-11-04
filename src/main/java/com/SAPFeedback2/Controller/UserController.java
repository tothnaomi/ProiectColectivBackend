package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HERE WE WILL CALL ONLY THE HTTPCLIENT IN EVERY FUNCTION !!
 * POST: add
 * PUT: update, delete
 * GET: read
 * DELETE: delete
 * here will we have the actual links: localhost.getAllUsers... HTTPClient
 */
@RestController
public class UserController {
    private final EmployeeService employeeService;

    // dependency injection
    @Autowired
    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // --------------------------------- HTTP CLIENT ---------------------------------

    @GetMapping("api/employee/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("api/employee/addEmployee")
    public void addEmplyee(@RequestBody Employee employee) {
        System.out.println(employee.getFirstName());
        employeeService.addEmployee(employee);
    }

    @GetMapping("api/employee/getEmployeeByPersonalNumber/{personalNumber}")
    public Employee getEmployeeByPersonalNumber(@PathVariable("personalNumber") Long personalNumber) {
        return employeeService.getEmployeeByPersonalNumber(personalNumber).orElse(null);
    }

    @DeleteMapping("api/employee/deleteEmployeeByPersonalNumber/{personalNumber}")
    public int deleteUserById(@PathVariable("personalNumber") Long personalNumber) {
        return employeeService.deleteEmployee(personalNumber);
    }

    @PutMapping("api/employee/updateEmployee/{personalNumber}")
    public int updateEmployee(@PathVariable("personalNumber") Long personalNumber, @RequestBody Employee employee) {
        return employeeService.updateEmployee(personalNumber, employee);
    }
}
