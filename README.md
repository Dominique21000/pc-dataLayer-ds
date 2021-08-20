# dataLayer 
**application Java EE dans la cadre de la MOOC : Utilisez Spring Data pour interagir avec vos bases de données**

## Niveau Java EE
- 2 dépendances 
	- Spring Data JPA
	- MySQL Driver
	

## Le Model

- produit
- commentaire
- categorie


## Les règles 
- un produit peut être associé à plusieurs catégories
- un produit peut avoir 1 ou plus de commentaires
- un commentaire appartient à un produit




## Les relations
- Produit - Commentaire : OnetoMany
- Produit - Categorie : ManyToMany

## Les annotations
- au niveau de la classe, pour la lier à la table
	- @Entity
	- @Table (name = "nom de la table")

- au niveau de de l'id 
	- @Id
	- @GeneratedValue(strategy = GenerationType.IDENTITY)
	
- au niveau des attributs 	
	- @Column(name = "nom de la colonne dans la base")
	
- pour les relations 
	- unidirectionnelles 
		- @OneToMany : pour les liste Un à plusieurs sur la liste , avec les attributs
			- cascade : définit la façon dont agira l'attribue en foncton de son parent
			- orphanRemoval : pour éviter ou non les orphélins (commentaire sans produit
			- fetch : la façon dont les enfants sont récupéré par rapport au parents
		- @JoinColumn : faire l'association avec la base
			- name = clé étrangères
	- bi directionnelles	 : 
		- @ManyToMany : 
			- fetch
			- cascade						
		- @JoinTable 
			- name : nom de le table de jointure
			- joinColumn = @JoinColumn la clé étrangère dans la table de jointure
			- inverseJoinColumn = @JoinColumn la clé étrangère dans la table de jointure de la seconde entité
			
		
	
## Lors d'une relation bidirectionnelles
- OneToMany / ManyToMany : il faut qu'elle soit liée des deux cotés
	- d'un coté 
		- @ManyToMany
		- @JoinTable
	- de l'autre : mettre un champ qui fera la liaison, avec 
		- ManyToMany 
			- mappeedBy = le nom de l'attribut correspond à cette classe dans la class associée

- @JoinColmun : name = clé étrangère dans la table qu'on gère



### Dans une vraie laision bidirectionnelle 
- un seul des coté fait le lien avec @JoinColumn
- de l'autre => mappedBy dans le ..toMany

@ManyToOne doit être maître de la relation => 
- @JoinColmun
 

			
- ajouter des fonctions utilitaires pour gérer les enfants 
 	- OneToManu : du coté du OnetoMany (là où on gère la liste) 
	- ManytoMany : du coté du JoinTable 
			
			
			

			