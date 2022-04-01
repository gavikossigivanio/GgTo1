package com.example.tp1.controller;

import com.example.tp1.modele.Categorie;
import com.example.tp1.repository.CategorieRepository;
import com.example.tp1.repository.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/afficher")
    public String DisplayCategorie(Model model){
        model.addAttribute("categorie" , categorieService.showAllCategorie());
        return "/categorie/showAllCategorie";
    }
    @GetMapping("/fromCategorie")
    public String Enregistre(){return "Categorie/formCategorie";}
    @PostMapping("/Save")
    public String SaveCategorie(Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/categorie/afficher";
    }
    @GetMapping("/edit/{id}")
    public String editFormCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("uneCategorie",categorieService.selectOneCategorie(id));
        return "categorie/formEditCategorie";
    }
    @PostMapping("/edit")
    public String editCategorie(@PathVariable("categorie") Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/categorie/afficher";
    }
}
