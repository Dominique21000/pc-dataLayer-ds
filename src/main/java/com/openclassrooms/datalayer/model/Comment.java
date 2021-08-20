package com.openclassrooms.datalayer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Comment {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "commentaire_id")
	private int id;
	
	@Column(name = "contenu")
	private String content;
	
	@ManyToOne(  // car plusieurs comme => 1 produit
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinColumn(name = "produit_id") // clé étrangère de la table produit
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
