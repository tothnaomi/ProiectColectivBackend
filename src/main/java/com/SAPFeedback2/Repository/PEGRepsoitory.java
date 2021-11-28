package com.SAPFeedback2.Repository;

import com.SAPFeedback2.Model.PEG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PEGRepsoitory extends JpaRepository<PEG, Long> {
    List<PEG> findAll();
}
