package fr.enseirb.persistance.projet;

import java.util.List;





public interface JouetDAO {

	Jouet updateJouet(Jouet jouet);
	long getStockChaine(String type);
	long getStockMagasin(String nameMag);
	List<JouetVideo> selectJouetsVidéoSurCritère(String nomMag,String typeConsole);
}
