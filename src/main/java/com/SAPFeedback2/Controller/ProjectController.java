package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Project;
import com.SAPFeedback2.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("api/project/getAll")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("api/project/getProjectById/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.findById(id).orElse(null);
    }
}
