package com.example.tp1.repository.service;

import com.example.tp1.modele.Produit;
import com.example.tp1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    public List<Produit> showProduits(){
        return produitRepository.findAll();
    }

    public Produit showOneProduit(int id){
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;

        if (optional.isPresent()){
            produit = optional.get();
        }
        else {
            return  produit;
        }
        return produit;
    }

}