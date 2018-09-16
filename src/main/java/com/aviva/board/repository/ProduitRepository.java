package com.aviva.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aviva.board.model.Produit;
import com.aviva.board.model.Role;


@Repository("produitRepository")
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	//Role findByRole(String role);

}
