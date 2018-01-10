package fr.enseirb.persistance.projet;
import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChaineDeMagasins {
	
  private int chaine_id;
  private String nom_chaine;
  private Collection<Magasin> magasins;
  
  public ChaineDeMagasins()
  {}
  
  public ChaineDeMagasins(String nom_chaine){
	  this.nom_chaine=nom_chaine;
	  magasins=new LinkedList<Magasin>();
  }

public void setMagasins(Collection<Magasin> magasins) {
	this.magasins = magasins;
}

@OneToMany(mappedBy="chainedemagasins")
public Collection<Magasin> getMagasins() {
	return magasins;
}

public void setNom_chaine(String nom_chaine) {
	this.nom_chaine = nom_chaine;
}

public String getNom_chaine() {
	return nom_chaine;
}

public void setChaine_id(int chaine_id) {
	this.chaine_id = chaine_id;
}

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
public int getChaine_id() {
	return chaine_id;
}

  public void addMagasin(Magasin magasin) {
    magasins.add(magasin);
  }

  /*public Magasin getMagasin(String nom) {
    for (Iterator<Magasin> i = magasins.iterator(); i.hasNext(); ) {
      Magasin magasin = (Magasin)i.next();
      if (magasin.getNom().equals(nom)) {
        return magasin;
      }
    }
    return null;
  }*/

}

