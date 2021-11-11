package com.SAPFeedback2.Repository;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository {

    List<Team> findAll();

    Optional<Team> findById(Long id);

    Optional<Team> findByManager(Employee manager);

}
