package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public AuthentificationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<?> login(String email, String password) throws Exception {

        Employee employee = employeeRepository.findByEmail(email).orElse(null);
        if (employee != null && employee.getPassword().equals(password)) {
            employee.setLoggedIn(1);
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found!", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> logout(String email) throws Exception {
        Employee employee = employeeRepository.findByEmail(email).orElse(null);

        if (employee == null) {
            return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
        }

        if (employee.getLoggedIn() == 0) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        employee.setLoggedIn(0);
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    public ResponseEntity<?> forgotPassword(String username, String newPassword, String confirmPassword) throws Exception {
        Employee employee = employeeRepository.findByUsername(username).orElse(null);

        if (employee == null) {
            return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
        }

        if (!newPassword.equals(confirmPassword)) {
            return new ResponseEntity<>(employee, HttpStatus.CONFLICT);
        }

        employee.setPassword(newPassword);
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}
