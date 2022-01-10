package com.SAPFeedback2.Controller;


import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("api/team/getAll")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping("api/team/getById/{id}")
    public Team getTeamById(@PathVariable("id") Long id) {
        return teamService.getTeamById(id).orElse(null);
    }

    @GetMapping("api/team/getByManager/{id}")
    public Team getTeamByManager(@PathVariable("id") Long id) {
        return teamService.getTeamByManagerId(id).orElse(null);
    }
}
