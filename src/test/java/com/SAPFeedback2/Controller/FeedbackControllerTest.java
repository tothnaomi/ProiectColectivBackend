package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.EmployeeService;
import com.SAPFeedback2.Service.FeedbackService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
public class FeedbackControllerTest {

    @Autowired
    public FeedbackService feedbackService;

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public MockMvc mvc;

    @BeforeEach
    public void setUp(){
        Employee employee= new Employee(6000611084524L,"Ana", "Pop", "taflan.cristina@yahoo.com"," ", "",1);
        Employee employee2= new Employee(6000611084534L,"Ana", "Pop", "taflan.cristina@yahoo.com"," ", "",1);
        Feedback feedback= new Feedback(1, "text", true,"a", "b"," ", " " );
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee2);
        Optional<Employee> employee1=employeeService.getEmployeeByPersonalNumber(employee.getPersonalNumber());
        Optional<Employee> employee3=employeeService.getEmployeeByPersonalNumber(employee2.getPersonalNumber());
        feedback.setEmployee1(employee1.orElse(null));
        feedback.setEmployee2(employee3.orElse(null));
        feedbackService.addFeedback(feedback);
    }

    @Test
    void getAll() throws Exception {
        RequestBuilder getAll=get("/api/feedback/getAll")
                .contentType(MediaType.APPLICATION_JSON);

       mvc.perform(getAll)
               .andExpect(status().isOk())
       .andExpect(jsonPath("$", Matchers.hasSize(1)))
               .andExpect(jsonPath("$[0].id").value(1));

    }

    @Test
    void getFeedBackReceivedByEmployeeId() throws Exception {
        RequestBuilder getFeedBackReceivedByEmployeeId=get("/api/feedback/getFeedbackReceivedByEmployeeId/{id}",6000611084534L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getFeedBackReceivedByEmployeeId)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(1));
    }


    @Test
    void getFeedBackGivenByEmployeeId() throws Exception {
        RequestBuilder getFeedBackGivenByEmployeeId=get("/api/feedback/getFeedbackGivenByEmployeeId/{id}",6000611084524L)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getFeedBackGivenByEmployeeId)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    void addFeedback() throws Exception {
        Feedback feedback= new Feedback(18L, "text", true,"a", "b"," ", " " );
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(feedback);

        RequestBuilder addFeedBack=post("/api/feedback/addFeedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json));

       mvc.perform(addFeedBack)
               .andExpect(status().isOk());


    }
}