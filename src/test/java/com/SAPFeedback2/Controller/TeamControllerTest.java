package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.Model.Team;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.EmployeeService;
import com.SAPFeedback2.Service.TeamService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
class TeamControllerTest {

    @Autowired
    public TeamService teamService;

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public MockMvc mvc;

    @BeforeEach
    public void setUp(){
        Employee employee= new Employee(6000611084524L,"Cristina", "Taflan", "taflan.cristina@yahoo.com","taflanc ", "parola1",1);
        employeeService.addEmployee(employee);

        Team team= new Team(1L, "Team1", employeeService.getAll().get(0));
        teamService.save(team);
    }

    @Test
    void getAll() throws Exception {
        RequestBuilder getAll=get("/api/team/getAll")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getAll)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    void getTeamById() throws Exception {
        RequestBuilder getTeamById=get("/api/team/getById/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getTeamById)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Team1"));

    }

    @Test
    void getTeamByManagerId() throws Exception {
        RequestBuilder getTeamByManagerId=get("/api/team/getByManager/{id}", 6000611084524L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getTeamByManagerId)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Team1"));

    }

}