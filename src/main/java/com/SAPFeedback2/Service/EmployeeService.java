package com.SAPFeedback2.Service;

import com.SAPFeedback2.Dao.EmployeeDao;
import com.SAPFeedback2.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * in our project it does not have sense to have a service and a repository, but in complexer projects here would we have the logic of the applciation
 */
@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    // we use annotations to instantiate beans
    @Autowired
    public EmployeeService(@Qualifier("postgres") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }

    public Optional<Employee> getEmployeeByPersonalNumber(Long personalNumber) {
        return employeeDao.selectEmployeeByPersonalNumber(personalNumber);
    }

    public int deleteEmployee(Long personalNumber) {
        return employeeDao.deleteEmployeeByPersonalNumber(personalNumber);
    }

    public int updateEmployee(Long personalNumber, Employee employee) {
        return employeeDao.updateEmployeeByPersonalNumber(personalNumber, employee);
    }
}
