package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
class EmployeeControllerTest {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public MockMvc mvc;

    @BeforeEach
    public void setUp(){
        Employee employee= new Employee(6000611084524L,"Ana", "Pop", "taflan.cristina@yahoo.com"," ", "",1);
         employeeService.addEmployee(employee);

    }

    @Test
    void getAll() throws Exception {
        RequestBuilder getAll=get("/api/employee/getAll")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getAll)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    void getManagers() throws Exception {
        RequestBuilder getManagers=get("/api/employee/getManagers")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getManagers)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    void getEmployeeWithPersonalNumber() throws Exception {
        addEmployee();
        RequestBuilder getEmployeeWithPersonalNumber=get("/api/employee/getEmployeeByPersonalNumber/{personalNumber}",6000611084524L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getEmployeeWithPersonalNumber)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("Taflan"));
    }


    @Test
    void deleteEmployeeWithPersonalNumber() throws Exception {
        addEmployee();
        RequestBuilder deleteEmployeeWithPersonalNumber=delete("/api/employee/deleteEmployeeByPersonalNumber/{personalNumber}",6000611084524L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(deleteEmployeeWithPersonalNumber)
                .andExpect(status().isOk());
    }

    @Test
    void addEmployee() throws Exception {
        Employee employee= new Employee(6000611084524L,"Cristina", "Taflan", "taflan.cristina@yahoo.com","taflanc ", "parola1",1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(employee);

        RequestBuilder addFeedBack=post("/api/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json));

        mvc.perform(addFeedBack)
                .andExpect(status().isOk());
    }
}