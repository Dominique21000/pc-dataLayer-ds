package com.openclassrooms.datalayer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Category {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "categorie_id")
	private int id;
	
	@Column(name="nom")
	private String name;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
			})
	@JoinTable(
			name = "categorie_produit", // table de liaison
			joinColumns = @JoinColumn(name = "categorie_id"), // la fk
			inverseJoinColumns = @JoinColumn(name = "produit_id") // indique le chemin pour aller vers le produot
			
	)
	private List<Product> products = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		product.getCategories().add(this);
	}
 
	public void removeProduit(Product product) {
		products.remove(product);
		product.getCategories().remove(this);
	}

}
