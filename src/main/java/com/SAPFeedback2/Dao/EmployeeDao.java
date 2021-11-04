package com.SAPFeedback2.Dao;
import com.SAPFeedback2.Model.Employee;
import java.util.List;
import java.util.Optional;

/**
 * here will we define the operations allowed for the User model
 */
public interface EmployeeDao {
    int insertEmployee(Employee user);

    List<Employee> selectAll();

    Optional<Employee> selectEmployeeByPersonalNumber(Long personalNumber);

    int deleteEmployeeByPersonalNumber(Long personalNumber);

    int updateEmployeeByPersonalNumber(Long personalNumber, Employee newEmployee);
}
