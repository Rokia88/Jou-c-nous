package fr.enseirb.persistance.projet;
import java.util.Iterator;
import java.util.List;

import fr.enseirb.persistance.projet.hibernate.JouetDAOImpl;



public class JouetClient {

	static JouetDAO getJouetDAO() 
	{
		return new  JouetDAOImpl();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChaineDeMagasins chainedemagasins=new ChaineDeMagasins("chaine1");
		Magasin magasin=new Magasin("maga1","addr_mag1",555);
		Stock st=new Stock();
		Stock st1=new Stock();
		st.setMagasin(magasin);
		magasin.addStock(st);
		Magasin magasin1=new Magasin("maga2","addr_mag2",666);
		magasin.setChainedemagasins(chainedemagasins);
		magasin1.setChainedemagasins(chainedemagasins);
		st1.setMagasin(magasin1);
		magasin1.addStock(st1);
		chainedemagasins.addMagasin(magasin);
		chainedemagasins.addMagasin(magasin1);
		Jouet jouet=new JouetPuzzle("supperSoccer2012","jouer du puzzle",23);
		Jouet jouetbis=new JouetPuzzle("supperSoccer2012","jouer du puzzle",20);
		//Jouet jouet1=new JouetPuzzle("supperSoccer2011","jouer du puzzle",27);
		Jouet jouet1=new JouetVideo("supperSoccer2011",12,6,"JouetVideo","SuperGamer");
		Jouet jouet2=new JouetPuzzle("supperSoccer2010","jouer du puzzle",30);
		Jouet jouet3=new JouetPuzzle("supperSoccer2012","jouer du puzzle",34);
		Fournisseur fournisseur=new Fournisseur("fourn1","addr_four1",324);
		Fournisseur fournisseur1=new Fournisseur("fourn2","addr_four2",380);
		jouet.setFournisseur(fournisseur);
		jouetbis.setFournisseur(fournisseur);
		jouet.setMagasin(magasin);
		jouetbis.setMagasin(magasin);
		jouet1.setMagasin(magasin);
		jouet1.setFournisseur(fournisseur1);
		jouet2.setMagasin(magasin1);
		jouet2.setFournisseur(fournisseur1);
		jouet3.setMagasin(magasin1);
		jouet3.setFournisseur(fournisseur);
		magasin.addJouet(jouet,st);
		magasin.addJouet(jouetbis,st);
		magasin.addJouet(jouet1,st);
		magasin1.addJouet(jouet2,st1);
		magasin1.addJouet(jouet3,st1);
		Jouet persistJouet=JouetClient.getJouetDAO().updateJouet(jouet);
		Jouet persistJouetbis=JouetClient.getJouetDAO().updateJouet(jouetbis);
		Jouet persistJouet1=JouetClient.getJouetDAO().updateJouet(jouet1);
		Jouet persistJouet2=JouetClient.getJouetDAO().updateJouet(jouet2);
		Jouet persistJouet3=JouetClient.getJouetDAO().updateJouet(jouet3);
		System.out.println("le nombre de jouets supperSoccer2012 en stock dans tt la chaine "+JouetClient.getJouetDAO().getStockChaine("supperSoccer2012"));
		System.out.println("le nombre de jouets supperSoccer2011 en stock dans tt la chaine "+JouetClient.getJouetDAO().getStockChaine("supperSoccer2011"));
		System.out.println("le nombre de jouets supperSoccer2010 en stock dans tt la chaine "+JouetClient.getJouetDAO().getStockChaine("supperSoccer2010"));
		System.out.println("le nombre de jouet dans maga1 "+JouetClient.getJouetDAO().getStockMagasin("maga1"));
		System.out.println("le nombre de jouet dans maga2 "+JouetClient.getJouetDAO().getStockMagasin("maga2"));
		List<JouetVideo> jouets=JouetClient.getJouetDAO().selectJouetsVidéoSurCritère("maga1", "SuperGamer");
		Iterator<JouetVideo> it=jouets.iterator();
		while(it.hasNext())
		{
			JouetVideo j=it.next();
			System.out.println(j.getId_jouet()+" "+j.getNom()+" "+j.getTypeConsole()+" "+j.getDescription());
		}
	}

}
