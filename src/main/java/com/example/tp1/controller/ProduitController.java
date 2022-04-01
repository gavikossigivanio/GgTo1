package com.example.tp1.controller;

import com.example.tp1.modele.Produit;
import com.example.tp1.repository.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/afficher")
    public String DisplayProduit(Model model){
        model.addAttribute("produit",produitService.showProduits());
        return "produits/showProduit";
    }
    @GetMapping("/form")
    public String renseign(){
        return  "Produits/produit";
    }
    @PostMapping("/save")
    public String save(Produit produit){
        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }
    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("UnProduit",produitService.showOneProduit(id));
        return "produits/formUpdate";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit(produit);
        return "redirect:produits/afficher";
    }

    @PostMapping("delete")
    public String deleteProduit(){
        return "";
    }
}
