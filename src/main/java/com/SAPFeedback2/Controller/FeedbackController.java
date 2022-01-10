package com.SAPFeedback2.Controller;


import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("api/feedback/getAll")
    public List<Feedback> getAll() {
        return feedbackService.getAll();
    }

    @GetMapping("api/feedback/getFeedbackReceivedByEmployeeId/{id}")
    public List<Feedback> getFeedBackReceivedByEmployeeId(@PathVariable("id") Long id) {
        return feedbackService.getFeedbackReceivedByEmployeeId(id);
    }

    @GetMapping("api/feedback/getFeedbackGivenByEmployeeId/{id}")
    public List<Feedback> getFeedBackGivenByEmployeeId(@PathVariable("id") Long id) {
        return feedbackService.getFeedbackGivenByEmployeeId(id);
    }

    @PostMapping("api/feedback/addFeedback")
    public void addFeedback(@RequestBody Feedback feedback) {
        System.out.println(feedback);
        feedbackService.addFeedback(feedback);
    }
}
