package com.aviva.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aviva.board.model.Produit;
import com.aviva.board.repository.ProduitRepository;

@SpringBootApplication
public class Aviva2Application {

	public static void main(String[] args) {
	ApplicationContext ctx=	SpringApplication.run(Aviva2Application.class, args);
	
	ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
	produitRepository.save(new Produit(10.5,"HP 1111",11));
	produitRepository.save(new Produit(11.5,"HP 2222",23));
	produitRepository.save(new Produit(12.5,"HP 3333",20));
	produitRepository.save(new Produit(132.5,"HP 4444",22));
	
	}
}
