package com.openclassrooms.datalayer;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import com.openclassrooms.datalayer.service.ProductService;
import com.sun.xml.bind.v2.runtime.output.XMLStreamWriterOutput;

@SpringBootApplication
public class DatalayerApplication  implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired 
	private CommentService commentService;
	
	private int noProduit;
	
	

	public static void main(String[] args) {
		SpringApplication.run(DatalayerApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String ...args) throws Exception{
		
		noProduit = 1;
		Iterable<Product> products = productService.getProducts();
		System.out.println("Liste des produits :");
		products.forEach(product -> System.out.println(product.getName()));
		System.out.println(" ");
		Iterable<Category> categories = categoryService.getCategories();
		System.out.println("Liste des categories :");
		categories.forEach(category -> System.out.println(category.getName()));
		
		System.out.println(" ");
		Iterable<Comment> comments = commentService.getComments();
		System.out.println("Liste des commentaires");
		comments.forEach(comment -> System.out.println(comment.getContent()));
		
		System.out.println("===========================");
		System.out.println("Produit 1 : ");
		Optional<Product> optProduct = productService.getProductById(noProduit);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());
		System.out.println("ses commentaires : ");
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));
		System.out.println("ses catégories : ");
		productId1.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		System.out.println(" ");
		
		System.out.println("Categorie 1 : ");
		Optional<Category> optCateg = categoryService.getCategoryById(1);
		Category categ1 = optCateg.get();
		System.out.println(categ1.getName());
		System.out.println(" ");
		System.out.println("Produit de la catégorie 1 : ");
		categ1.getProducts().forEach(
				product -> System.out.println(product.getName()));
		
			
		
		System.out.println(" ");
		System.out.println("Commentaire 1 : ");
		Optional<Comment> optComment = commentService.getCommentById(1);
		Comment comment1 = optComment.get();
		System.out.println(comment1.getContent());
		System.out.println("son produit : ");
		System.out.println(comment1.getProduct().getName());
	
		/*
		// creation de Promotioon
		String nCateg = "Promotion";
		System.out.println("création de l'objet : " + nCateg);
		Category newCateg = new Category();
		newCateg.setName(nCateg);
		newCateg = categoryService.AddCategory(newCateg);
		// on affiche
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));	
		
		// ajout de l'assurance
		// on créer le produit
		String nAssuName = "Nouvelle assurance";
		String nAssuDescr = "La description de la nouvelle assurance";
		Product nProduct = new Product();
		nProduct.setName(nAssuName);
		nProduct.setDescription(nAssuDescr);
		nProduct.setCost(1000);
		
		// on le sauv
		nProduct = productService.saveProduct(nProduct);
		
		// on lie les deux, les deux étant sauvés en base.
		newCateg.addProduct(nProduct);
		
		*/
		
		System.out.println("Les catégories : ");
		categoryService.getCategories().forEach(
				category -> 
				{
					System.out.print(category.getId() + " - ");
					System.out.println(category.getName());
				}
			);
		
		
		// on affiche les produits
		System.out.println("Les produits : ");
		productService.getProducts().forEach(
				product -> 
				{
					System.out.print(product.getProductId() + " - ");
					System.out.println(product.getName());
				}
			);

		// on affiche les produits
		System.out.println("Les commentaire : ");
		commentService.getComments().forEach(
				comment -> 
				{
					System.out.print(comment.getId() + " - ");
					System.out.println(comment.getContent());
				}
			);
		
		/*
		System.out.println("Les categ du nouveau produit : ");
		nProduct.getCategories().forEach(
					categorie -> 
					{
						System.out.print(categorie.getId() + " - ");
						System.out.println(categorie.getName() );
					}
			);				
		*/		
		
		/*
		// on récupère un produit
		Product productAssuranceAuTiers = productService.getProductById(1).get();
		// on crée le commentaire 
		Comment newComment = new Comment();
		newComment.setContent("Assurance peu intéressante");
		// on associe les deux
		productAssuranceAuTiers.addComment(newComment);
		*/		
		// suppression
		// produit
	//	productService.deleteProduct(7);
		
		// Category
	//	categoryService.deleteCategory(8);
		
		// Comment
		commentService.deleteCommentaire(11);
		System.out.println("Commentaire 11 effacé");
		
		// on affiche les produits
		System.out.println("Les commentaire : ");
		commentService.getComments().forEach(
				comment -> 
				{
					System.out.print(comment.getId() + " - ");
					System.out.println(comment.getContent());
				}
		);
		
		System.out.println("Assurance tous risques ?");
		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
	/*	searchResults.forEach(
				product -> System.out.println(product.getProductId())
		);
	*/	
		
		// recherche
		// test de recherche de produit par le nom de la categ
		System.out.println("produit de la categ Standard");
		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(
				product -> System.out.println(product.getName())
		);
				
		// categories par son nom
		System.out.println("recherche de Standard");
		Iterable<Category>rc1 = categoryService.getCategoriesByName("Standard");
		rc1.forEach(
				category -> System.out.println(category.getId() + " - " + category.getName())
		);
		
			
		// categories par le nom d'un produit
		System.out.println("recherche cat de AssuranceTousRisquesJeunes");
		Iterable<Category> rc2 = categoryService.getCategoriesByNameOfProduct("AssuranceTousRisquesJeunes");
		rc2.forEach(
				category -> System.out.println(category.getId() + " - " + category.getName())
		);
		
		// produit par cout inférieur à 1 000
		System.out.println("Produit de moins de 1000");
		Iterable<Product> rp1 = productService.getProductByCostUnder(1000);
		rp1.forEach(
				product -> System.out.println(product.getProductId() + " - " + product.getName())
		);
		
		// commentaire dont le contenu contient le mot déçu
		System.out.println("Commentaire contenaant le mot deçu");
		Iterable<Comment> rco1 = commentService.getCommentByContent("deçu");
		rco1.forEach(
				comment -> System.out.println(comment.getId() + " - " + comment.getContent())
		);
	}
}