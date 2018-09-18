package com.aviva.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aviva.board.model.Produit;
import com.aviva.board.repository.ProduitRepository;

@Controller
public class ProduitController {

	
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model, @RequestParam(name="page",defaultValue="0") int p , @RequestParam(name="size",defaultValue="5") int s, @RequestParam(name="motCle",defaultValue="")String mc) {
		//Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(page,s));
		//Page<Produit> pageProduits=produitRepository.findAll(PageRequest.of(p,s));
		Page<Produit> pageProduits=produitRepository.chercher("%"+mc+"%", PageRequest.of(p,s));
		
		
		model.addAttribute("listeProduits",pageProduits.getContent());
        int[] pages= new int[pageProduits.getTotalPages()];
    	model.addAttribute("pages",pages);
    	model.addAttribute("pageCourante",p);
    	model.addAttribute("size",s);
    	model.addAttribute("motCle",mc);
    	
		return "produits";//retourne vue produits.html
	}
}
