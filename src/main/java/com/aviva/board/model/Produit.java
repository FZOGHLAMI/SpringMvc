package com.aviva.board.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {

	
	@Id @GeneratedValue
	private Long id;
	private double prix;
	private String designation;
	private int quantite;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(double prix, String designation, int quantite) {
		super();
		this.prix = prix;
		this.designation = designation;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}