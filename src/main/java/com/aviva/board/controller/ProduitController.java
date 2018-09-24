package com.aviva.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aviva.board.model.Produit;
import com.aviva.board.repository.ProduitRepository;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		// Page<Produit> pageProduits=produitRepository.findAll(new
		// PageRequest(page,s));
		Page<Produit> pageProduits = produitRepository.chercher("%" + mc + "%", PageRequest.of(p, s));

		// Refresh Request
		model.addAttribute("listeProduits", pageProduits.getContent());
		int[] pages = new int[pageProduits.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("size", s);
		model.addAttribute("motCle", mc);

		return "produits";// retourne vue produits.html
	}

	@RequestMapping(value = "/delete")
	public String delete(Long id, String motCle, int page, int size) {
		produitRepository.deleteById(id);
		return "redirect:/index?page=" + page + "&size=" + size + "&motCle=" + motCle;// retourne vue produits.html
	}
	@RequestMapping(value = "/form",method=RequestMethod.GET)
	public String formPoroduit(Model model) {
		model.addAttribute("produit", new Produit());
		return "formProduit";
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public String savePoroduit(Model model,@Valid Produit produit,BindingResult bindingResult) {
	
		if(bindingResult.hasErrors()) {
			return "formProduit";
		}
		
		produitRepository.save(produit);
		return "confirmation";
	}
	
}
