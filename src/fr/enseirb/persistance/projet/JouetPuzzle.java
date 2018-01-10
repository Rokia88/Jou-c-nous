package fr.enseirb.persistance.projet;

import javax.persistence.Entity;


@Entity
public class JouetPuzzle extends Jouet {
	
	private int nombrePiece;
	
	public JouetPuzzle()
	{}

	public JouetPuzzle(String nom,String description,int nombrePiece) {
		super(nom,description);
		this.setNombrePiece(nombrePiece);
		// TODO Auto-generated constructor stub
	}

	public void setNombrePiece(int nombrePiece) {
		this.nombrePiece = nombrePiece;
	}

	public int getNombrePiece() {
		return nombrePiece;
	}

}
