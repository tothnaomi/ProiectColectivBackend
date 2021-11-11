package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Optional<Team> getTeamByManager(Employee manager) {
        return teamRepository.findByManager(manager);
    }
}
