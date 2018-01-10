package fr.enseirb.persistance.projet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

@Entity
public class Magasin{
	
	private String nom;
	private String adresse;
	private int tel;
	private int id_magasin;
	private Collection<Jouet> jouets;
	private ChaineDeMagasins chainedemagasins;
	private Collection<Stock> stocks;
	
	
	public Magasin(String nom, String adresse, int tel) {
	   this.nom=nom;
	   this.adresse=adresse;
	   this.tel=tel;
	   jouets=new LinkedList<Jouet>();
	   stocks=new LinkedList<Stock>();

	}
	
	public Magasin()
	{}
	
	public void addJouet(Jouet jouet,Stock st)
	{
		jouets.add(jouet);
		boolean exist = false;
		boolean sort = false;
		Iterator<Stock> it=stocks.iterator();
		while(it.hasNext()&& exist==false )
		{
			st=it.next();
			if(st.getType()==null)
			{
				st.setQuantité(1);
				st.setType(jouet.getNom());
				sort=true;
				exist=true;
			}
			else if(sort==false && st.getType().equals(jouet.getNom()))
			  {
				st.setQuantité(st.getQuantité()+1);
				exist = true;
			  }		
		}
		
		if(exist==false)
		{
			this.addNewType(jouet.getNom());			
		}					
}
	
	public void addNewType(String type)
	{
		Stock stock=new Stock();
		stock.setMagasin(this);
		stock.setQuantité(1);
		stock.setType(type);
		this.addStock(stock);
	}
	public void addStock(Stock st)
	{
	stocks.add(st);
	}
	
	@OneToMany(mappedBy="magasin",cascade={CascadeType.ALL})
	public Collection<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Collection<Stock> stocks) {
		this.stocks = stocks;
	}

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

	@OneToMany(mappedBy="magasin")
	public Collection<Jouet> getJouets() {
		return jouets;
	}

	public void setChainedemagasins(ChaineDeMagasins chainedemagasins) {
		this.chainedemagasins = chainedemagasins;
	}

	@ManyToOne( cascade = { CascadeType.ALL})
	@JoinColumn(name="ChaineMagasin_ID")
	public ChaineDeMagasins getChainedemagasins() {
		return chainedemagasins;
	}

	public void setId_magasin(int id_magasin) {
		this.id_magasin = id_magasin;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId_magasin() {
		return id_magasin;
	}

}
