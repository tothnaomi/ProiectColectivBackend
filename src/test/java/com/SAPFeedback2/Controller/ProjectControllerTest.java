package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Project;
import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.ProjectService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
class ProjectControllerTest {
    @Autowired
    public MockMvc mvc;

    @Autowired
    public ProjectService projectService;

    @BeforeEach
    public void setUp(){
        Project project= new Project(1L, "Project1", "descriere");
        projectService.save(project);
    }



    @Test
    void getAll() throws Exception {
        RequestBuilder getAll=get("/api/project/getAll")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getAll)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Project1"));

    }

    @Test
    void getProjectById() throws Exception {
        RequestBuilder getProjectById=get("/api/project/getProjectById/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getProjectById)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Project1"));

    }

}