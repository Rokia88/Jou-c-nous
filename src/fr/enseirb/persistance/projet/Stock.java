package fr.enseirb.persistance.projet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {
	
	private int id_stock;
	private Magasin magasin;
	private String type;
	private int quantit�;
	
	public Stock()
	{
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_stock() {
		return id_stock;
	}
	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@ManyToOne( cascade = { CascadeType.ALL})
	@JoinColumn(name="id_magasin")
	public Magasin getMagasin() {
		return magasin;
	}

}
