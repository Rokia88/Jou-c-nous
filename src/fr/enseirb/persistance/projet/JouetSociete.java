package fr.enseirb.persistance.projet;

import javax.persistence.Entity;


@Entity
public class JouetSociete extends Jouet{

	private int maxJoueurs;
	private int minJoueurs;
	private int age;
	
	public JouetSociete()
	{}
	
	public JouetSociete(String nom, String description,int maxJoueurs,int minJoueurs,int age) {
		super(nom,description);
		this.setMaxJoueurs(maxJoueurs);
		this.setMinJoueurs(minJoueurs);
		this.age=age;
		// TODO Auto-generated constructor stub
	}

	public void setMaxJoueurs(int maxJoueurs) {
		this.maxJoueurs = maxJoueurs;
	}

	public int getMaxJoueurs() {
		return maxJoueurs;
	}

	public void setMinJoueurs(int minJoueurs) {
		this.minJoueurs = minJoueurs;
	}

	public int getMinJoueurs() {
		return minJoueurs;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

}
