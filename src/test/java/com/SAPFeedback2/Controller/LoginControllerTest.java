package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.AuthentificationService;
import com.SAPFeedback2.Service.EmployeeService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
class LoginControllerTest {

    @Autowired
    public AuthentificationService loginService;

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public MockMvc mvc;


    @BeforeEach
    public void setUp(){
        Employee employee= new Employee(6000611084524L,"Cristina", "Taflan", "taflan.cristina@yahoo.com","taflanc ", "parola1",1);
        Employee employee2= new Employee(6000611084534L,"Ana", "Popa", "popa.ana@yahoo.com"," ", "parola2",1);
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee2);
    }

    @Test
    void login() throws Exception {
        RequestBuilder login=post("/employee/login")
                .contentType(MediaType.APPLICATION_JSON)
                .param("email", "taflan.cristina@yahoo.com")
                .param("password","parola1");

        mvc.perform(login)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loggedIn").value(1));

    }

    @Test
    void logout() throws Exception {
        login();
        RequestBuilder logout=post("/employee/logout")
                .contentType(MediaType.APPLICATION_JSON)
                .param("email", "taflan.cristina@yahoo.com");

        mvc.perform(logout)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loggedIn").value(0));

    }

    @Test
    void forgotPassword() throws Exception {
        RequestBuilder forgotPassword=post("/employee/forgotPassword")
                .contentType(MediaType.APPLICATION_JSON)
                .param("username", "taflanc")
                .param("password","parola7")
                .param("confirm","parola7");

        mvc.perform(forgotPassword)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.password").value("parola7"));

    }
}