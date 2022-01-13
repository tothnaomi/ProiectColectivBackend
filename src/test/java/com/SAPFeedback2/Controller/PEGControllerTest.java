package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.PEG;
import com.SAPFeedback2.SapFeedback2Application;
import com.SAPFeedback2.Service.EmployeeService;
import com.SAPFeedback2.Service.PEGService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SapFeedback2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
class PEGControllerTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public PEGService pegService;

    @Autowired
    public EmployeeService employeeService;

    @BeforeEach
    public void setUp(){
        Employee employee= new Employee(6000611084524L,"Ana", "Pop", "taflan.cristina@yahoo.com"," ", "",1);
        employeeService.addEmployee(employee);
        PEG peg = new PEG();
        peg.setManager(employeeService.getAll().get(0));
        peg.setStatus(2);
        pegService.addPeg(peg);
    }

    @Test
    void getAll() throws Exception {
        RequestBuilder getAll=get("/api/peg/getAll")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(getAll)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    void getAllFromEmployeeWithId() throws Exception {
        RequestBuilder getAllFromEmployeeWithId=get("/api/peg/getAllFromEmployeeWithId")
                .contentType(MediaType.APPLICATION_JSON)
                .param("personalNumber","6000611084524L");

        mvc.perform(getAllFromEmployeeWithId)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].status").value(2));

    }

    @Test
    void getAllWithStatus() throws Exception {
        RequestBuilder getAllWithStatus=get("/api/peg/getAllWithStatus")
                .contentType(MediaType.APPLICATION_JSON)
                .param("status","2");

        mvc.perform(getAllWithStatus)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

}