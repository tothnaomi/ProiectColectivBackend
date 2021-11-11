package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.Service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("api/team/getAll")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping("api/team/getById")
    public Team getTeamById(@PathVariable("id") Long id) {
        return teamService.getTeamById(id).orElse(null);
    }

    @GetMapping("api/team/getByManager")
    public Team getTeamByManager(@PathVariable("manager") Employee manager) {
        return teamService.getTeamByManager(manager).orElse(null);
    }
}
