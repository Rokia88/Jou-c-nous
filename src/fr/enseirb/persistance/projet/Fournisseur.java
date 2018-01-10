package fr.enseirb.persistance.projet;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Fournisseur {
	
	private String nom;
	private String adresse;
	private int tel;
	private int id_fournisseur;
	private Collection<Jouet> jouets;
	
	public Fournisseur(String nom,String adresse,int tel)
	{
		this.nom=nom;
		this.adresse=adresse;
		this.tel=tel;
	}
	
	public Fournisseur()
	{}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public void setJouets(Collection<Jouet> jouets) {
		this.jouets = jouets;
	}

	@OneToMany(mappedBy="fournisseur")
	public Collection<Jouet> getJouets() {
		return jouets;
	}

	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId_fournisseur() {
		return id_fournisseur;
	}

}
