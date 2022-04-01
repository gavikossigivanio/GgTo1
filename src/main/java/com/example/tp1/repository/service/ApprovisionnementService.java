package com.example.tp1.repository.service;

import com.example.tp1.modele.Approvisionnement;
import com.example.tp1.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public  void  saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> ShowApprovisionnement(){
       return approvisionnementRepository.findAll();
    }
}
