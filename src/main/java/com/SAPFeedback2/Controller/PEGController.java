package com.SAPFeedback2.Controller;

import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.Model.PEG;
import com.SAPFeedback2.Service.FeedbackService;
import com.SAPFeedback2.Service.PEGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PEGController {
    private final PEGService pegService;

    @Autowired
    public PEGController(PEGService pegService) {
        this.pegService = pegService;
    }

    @GetMapping("api/peg/getAll")
    public List<PEG> getAll() {
        return pegService.getAll();
    }

    @GetMapping("api/peg/getAllFromEmployeeWithId/{personalNumber}")
    public List<PEG> getAllFromEmployeeWithId(@PathVariable("personalNumber") Long personalNumber) {
        return pegService.getAllFromEmployeeWithPersonalNumber(personalNumber);
    }

    @GetMapping("api/peg/getAllWithStatus")
    public List<PEG> getAllWithStatus(@RequestParam("status") Integer status) {
        return pegService.getAllWithStatus(status);
    }

    @PostMapping("api/peg/addPeg")
    public void addPeg(@RequestBody PEG peg) {
        System.out.println(peg);
        pegService.addPeg(peg);
    }
}
