package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * in our project it does not have sense to have a service and a repository,
 * but in complexer projects here would we have the logic of the application
 * TODO - Validations
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // we use annotations to instantiate beans
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByPersonalNumber(Long personalNumber) {
        return employeeRepository.findByPersonalNumber(personalNumber);
    }

    public void deleteEmployee(Long personalNumber) {
        employeeRepository.deleteEmployeeByPersonalNumber(personalNumber);
    }

    public List<Employee> getManagers() {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getStatus()==1)
                .collect(Collectors.toList());
    }

//    public int updateEmployee(Long personalNumber, Employee employee) {
//        return employeeDao.updateEmployeeByPersonalNumber(personalNumber, employee);
//    }
}
