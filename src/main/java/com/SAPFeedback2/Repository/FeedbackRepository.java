package com.SAPFeedback2.Repository;

import com.SAPFeedback2.Model.Employee;
import com.SAPFeedback2.Model.Feedback;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @NotNull List<Feedback> findAll();

    List<Feedback> getFeedbackByEmployee1(Optional<Employee> id);

    List<Feedback> getFeedbackByEmployee2(Optional<Employee> id);




}
