package com.openclassrooms.datalayer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="produit")
@DynamicUpdate
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private int productId;
	
	@Column(name = "nom")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cout")
	private int cost;

	// lien vers Comment
	@OneToMany(
			mappedBy = "product",  // sing car 1 produit par commentaire
			cascade = CascadeType.ALL,
			orphanRemoval = true
						
			)
	//@JoinColumn(name = "produit_id")	
	private List<Comment> comments = new ArrayList<>();
	
	
	// lien vers Category
	@ManyToMany(
			mappedBy = "products",    // nom de l'attribut correspondant dans la classe Categorie
			cascade = CascadeType.ALL
			)
	List<Category> categories = new ArrayList<>();
	
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrption) {
		this.description = descrption;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}
 
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}

}
