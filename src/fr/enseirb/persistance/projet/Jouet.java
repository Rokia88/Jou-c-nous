package fr.enseirb.persistance.projet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Jouet {

	private String nom;
	private String description;
	private int id_jouet;
	private Fournisseur fournisseur;
	private Magasin magasin;
	
	public Jouet()
	{}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Jouet(String nom,String description)
	{
		this.nom=nom;
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@ManyToOne( cascade = { CascadeType.ALL})
	@JoinColumn(name="Fournisseur_ID")
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setId_jouet(int id_jouet) {
		this.id_jouet = id_jouet;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId_jouet() {
		return id_jouet;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@ManyToOne( cascade = { CascadeType.ALL})
	@JoinColumn(name="Magasin_ID")
	public Magasin getMagasin() {
		return magasin;
	}
	
}
