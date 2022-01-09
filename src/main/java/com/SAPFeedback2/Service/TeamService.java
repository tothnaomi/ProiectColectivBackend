package com.SAPFeedback2.Service;


import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final EmployeeService employeeService;

    @Autowired
    public TeamService(TeamRepository teamRepository, EmployeeService employeeService) {
        this.teamRepository = teamRepository;
        this.employeeService = employeeService;
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Optional<Team> getTeamByManagerId(Long id) {
        return teamRepository.getTeamByManager(employeeService.getEmployeeByPersonalNumber(id));
    }

    public void save(Team team){ teamRepository.save(team);}
}
