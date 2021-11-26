package com.SAPFeedback2.Repository;//package com.SAPFeedback2.Repository;
//
//import com.SAPFeedback2.Dao.EmployeeDao;
//import com.SAPFeedback2.Model.Employee;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository("postgres")
//public class EmployeeRepository implements EmployeeDao {
//
//    private static List<Employee> employeeList = new ArrayList<>();
//
//    @Override
//    public int insertEmployee(Employee employee) {
//        employeeList.add(new Employee(employee.getPersonalNumber(), employee.getFirstName(), employee.getLastName(),employee.getEmail(), employee.getUsername(), employee.getPassword(), employee.getStatus()));
//        return 1;
//    }
//
//    @Override
//    public List<Employee> selectAll() {
//        return employeeList;
//    }
//
//    @Override
//    public Optional<Employee> selectEmployeeByPersonalNumber(Long personalNumber) {
//        return employeeList.stream()
//                .filter(employee -> employee.getPersonalNumber().equals(personalNumber))
//                .findFirst();
//    }
//
//    @Override
//    public int deleteEmployeeByPersonalNumber(Long personalNumber) {
//        Optional<Employee> person = selectEmployeeByPersonalNumber(personalNumber);
//
//        if (person.isEmpty()) {
//            // the person with this id is not in the database
//            return 0;
//        }
//        else {
//            employeeList.remove(person.get());
//            return 1;
//        }
//    }
//
//    @Override
//    public int updateEmployeeByPersonalNumber(Long personalNumber, Employee newEmployee) {
//        return selectEmployeeByPersonalNumber(personalNumber)
//                .map(employee -> {
//                    int indexEmployeeToUpdate = employeeList.indexOf(employee);
//                    if (indexEmployeeToUpdate >=0 ) {
//                        // we found the person in the database
//                        employeeList.set(indexEmployeeToUpdate, new Employee(newEmployee.getPersonalNumber(), newEmployee.getFirstName(), newEmployee.getLastName(),newEmployee.getEmail(), newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getStatus()));
//                        return 1;
//                    }
//                    return 0;
//                }).orElse(0);
//    }
//}

import com.SAPFeedback2.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    boolean deleteEmployeeByPersonalNumber(Long personalNumber);
    
    Optional<Employee> findByPersonalNumber(Long personalNumber);

}

