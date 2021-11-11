package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.Feedback;
import com.SAPFeedback2.Repository.EmployeeRepository;
import com.SAPFeedback2.Repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {


    private final FeedbackRepository feedbackRepository;

    private final EmployeeRepository employeeRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, EmployeeRepository employeeRepository) {
        this.feedbackRepository = feedbackRepository;

        this.employeeRepository = employeeRepository;
    }

    public void addFeedback(Feedback feedback)
    {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> getAll()
    {
        return feedbackRepository.findAll();
    }

    public List<Feedback> getFeedbackGivenByEmployeeId(Long id){
        return  feedbackRepository.getFeedbackByEmployee1(employeeRepository.findById(id));
    }

    public List<Feedback> getFeedbackReceivedByEmployeeId(Long id){
        return  feedbackRepository.getFeedbackByEmployee2(employeeRepository.findById(id));
    }
}
