package fr.enseirb.persistance.projet;

import javax.persistence.Entity;


@Entity
public class JouetVideo extends Jouet {

	private int ageMax;
	private String typeConsole;
	
	public int getAgeMax() {
		return ageMax;
	}

	public JouetVideo()
	{}
	
	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}


	public int getAgeMin() {
		return ageMin;
	}


	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}


	private int ageMin;
	
	
	public JouetVideo(String nom,int ageMax,int ageMin,String decription,String typeConsole) {
		
		super(nom, decription);
		this.ageMax=ageMax;
		this.ageMin=ageMin;
		this.typeConsole=typeConsole;
		
		// TODO Auto-generated constructor stub
	}

	public void setTypeConsole(String typeConsole) {
		this.typeConsole = typeConsole;
	}

	public String getTypeConsole() {
		return typeConsole;
	}
}
