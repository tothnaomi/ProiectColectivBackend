package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Project;
import com.SAPFeedback2.Service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("api/project/getAll")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("api/employee/getProjectById/{id}")
    public Project getEmployeeByPersonalNumber(@PathVariable("id") Long id) {
        return projectService.findById(id).orElse(null);
    }
}
