package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.Project;
import com.SAPFeedback2.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){this.projectRepository=projectRepository;}

    public List<Project> getAll(){return projectRepository.findAll();}

    public Optional<Project> findById(Long id){return projectRepository.findById(id);}


    public void save(Project project) { projectRepository.save(project);
    }
}
