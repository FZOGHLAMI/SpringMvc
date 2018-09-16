package com.aviva.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aviva.board.model.Produit;
import com.aviva.board.repository.ProduitRepository;

@Controller
public class ProduitController {

	
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Produit> liste=produitRepository.findAll();
		model.addAttribute("listeProduits",liste);
		return "produits";//retourne vue produits.html
	}
}
