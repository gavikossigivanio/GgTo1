package com.example.tp1.controller;

import com.example.tp1.repository.service.ApprovisionnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Approvisionnement")
public class ApprovisionnementController {
   @Autowired
   private ApprovisionnementService approvisionnementService;

   @GetMapping
    public String DisplayProduit(Model model){
       model.addAttribute("approvisionnement", approvisionnementService.ShowApprovisionnement());
       return "Approvisionnement/ShowApprovisionnement";
   }

   @GetMapping("/form")
    public  String EnregistreAppro(){

   }
}
