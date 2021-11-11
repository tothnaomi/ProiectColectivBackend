package com.SAPFeedback2.Repository;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAll();

    Optional<Team> findById(Long id);

    Optional<Team> getTeamByManager(Optional<Employee> manager);

}
