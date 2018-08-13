package fr.afcepf.ai104.sources;

public interface AnnuaireGlobalVariables {

    String fichierExterne = "/Users/roque/Documents/htdocs/Annuaire/src/stagiaire.don";
    String fichierBinaire = "/Users/roque/Documents/htdocs/Annuaire/src/preAnnuaire.don";

    int TAILLE_OCTETS_STAGIAIRE = 156;    // Taille de chaque enregistrement dans la base de données.
    int TAILLE_NOM = 30;    // Nom      30  * 2 = 60
    int TAILLE_PRENOM = 25;    // Prenom   25  * 2 = 50
    int TAILLE_DEPARTAMENT = 3;    // Dpt      3   * 2	= 6
    int TAILLE_PROMO = 10;    // Promo    10  * 2 = 20

    int TAILLE_NOM_OCTETS = 60;
    int TAILLE_PRENOM_OCTETS = 50;
    int TAILLE_DEPARTAMENT_OCTETS = 6;
    int TAILLE_PROMO_OCTETS = 20;

    /* 	TAILLE_ANNEEPROMO	        = 4;	// Année    1   * 4 = 4
     	TAILLE_ID			        = 4;	// Id Node  1   * 4 = 4
     	TAILLE_ID_GAUCHE	        = 4;	// Id Node  1   * 4 = 4
     	TAILLE_ID_DROITE	        = 4;	// Id Node  1   * 4 = 4
     	TAILLE_ID_PERE		        = 4;	// Id Node  1   * 4 = 4
    */

    int TAILLE_STRINGS_STAGIAIRE = 68;  // Addition taille de Nom, Prenom, Departement et Promo
    int POSITION_ID_NODE_PERE = (TAILLE_STRINGS_STAGIAIRE * 2) + 8;
}
