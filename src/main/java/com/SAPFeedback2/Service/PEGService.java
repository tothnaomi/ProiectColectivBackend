package com.SAPFeedback2.Service;

import com.SAPFeedback2.Model.PEG;
import com.SAPFeedback2.Repository.PEGRepsoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PEGService {
    private final PEGRepsoitory pegRepsoitory;

    @Autowired
    public PEGService(PEGRepsoitory pegRepsoitory) {
        this.pegRepsoitory = pegRepsoitory;
    }

    public List<PEG> getAll() {
        return pegRepsoitory.findAll();
    }


    public List<PEG> getAllFromEmployeeWithPersonalNumber(Long personalNumber) {
        return pegRepsoitory.findAll()
                .stream()
                .filter(peg -> peg.getEmployee().getPersonalNumber().equals(personalNumber))
                .collect(Collectors.toList());
    }

    public List<PEG> getAllWithStatus(Integer status) {
        return pegRepsoitory.findAll()
                .stream()
                .filter(peg -> peg.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public void addPeg(PEG peg) {
        peg.setStatus(1);
        pegRepsoitory.save(peg);
    }

}
