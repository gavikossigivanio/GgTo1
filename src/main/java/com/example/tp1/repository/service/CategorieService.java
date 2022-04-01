package com.example.tp1.repository.service;

import com.example.tp1.modele.Categorie;
import com.example.tp1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public List<Categorie> showAllCategorie(){
       categorieRepository.findAll();
        return null;
    }

    public Optional<Categorie> selectOneCategorie(int id){
      return categorieRepository.findById(id);
    }

    public Categorie deleteOneCategorie(int id){
        categorieRepository.deleteById(id);
        return null;
    }
}
