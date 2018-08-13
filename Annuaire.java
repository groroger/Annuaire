package IhmFinal;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Annuaire extends VBox{
	

	private VBox titre = new VBox();
	private GridPane haut = new GridPane();
	private VBox bas = new VBox();
	private VBox bas1 = new VBox();
	private HBox rechercher = new HBox();
	
	private HBox photoInfos1 = new HBox();
	private HBox photoInfos2 = new HBox();
	private VBox infos1 = new VBox();
	private VBox infos2 = new VBox();
	
	private HBox btnBas = new HBox();
	
//TEXT ET TEXTFIELD
	//private Text titres = new Text("Annuaire des stagiaires :" );		// MODIF ICI
	
	private Text nom = new Text("Nom " );
	private TextField tNom = new TextField("");		// MODIF ICI
	private Text prenom = new Text ("Prénom " );
	private TextField tPrenom = new TextField("");		// MODIF ICI
	
	private Text departement = new Text ("Département  ");
	private TextField dep = new TextField ("");
	
	private Text promo = new Text ("Promotion");
	private TextField tPromo = new TextField();		// MODIF ICI
	
	private Text annee = new Text ("Année");
	private TextField tAnnee = new TextField();		// MODIF ICI
	
//BOUTONS
	private Button btnRechercher = new Button("Rechercher");
	private Button btnAdd = new Button("Ajouter");

	public Button btnRetour = new Button ("Retour");
	
	public Button btnImprimer = new Button ("Imprimer");
	
	
	


	public Annuaire() {
		super();	
//HAUT DE PAGE	
	//ANNEE
	
		//
		// DEPARTEMENT
		//
				DepartementDAO dao = new DepartementDAO();
				ObservableList<Departement> observableDepartements = FXCollections.observableArrayList(dao.getDepartement());
				ComboBox<Departement> cb1 = new ComboBox<>(observableDepartements);
				cb1.getSelectionModel().select(75);
				cb1.setVisibleRowCount(5);
				
//									
//			ANNEE
//				
			
			ComboBox<String> cb = new ComboBox<>();
			
			// Determine l'annee en cours et remonte sur 40 ans pour le choix année
			Date date = new Date();
			SimpleDateFormat modelEcritureAnnee = new SimpleDateFormat("yyyy");
			String anneeEnCours = modelEcritureAnnee.format(date);
			int anneeAChoisir = 0;
			for (int i=0; i<40; i++) {
				anneeAChoisir= Integer.parseInt(anneeEnCours) - i;
			cb.getItems().add(String.valueOf(anneeAChoisir));
			}
			
			cb.getSelectionModel().select(0); // on commence la box par l'indice 0
			cb.setVisibleRowCount(4); 		  // on affiche que 4 elements dans la box + menu deroulant
				

		//titre.getChildren().add(titres);
		titre.setAlignment(Pos.CENTER);
		titre.setStyle("-fx-background-color:#e2fdff");
		//titres.setFont(Font.font("Verdana",40));
		
		tNom.setPrefWidth(300.);		// MODIF ICI
		tPrenom.setPrefWidth(250.);		// MODIF ICI
		tPromo.setPrefWidth(220.);		// MODIF ICI
		haut.addRow(1,nom,tNom,prenom,tPrenom,annee,cb,departement,cb1,promo,tPromo);		// MODIF ICI
		//haut.addRow(2,departement,cb1,promo,tpromo);		// MODIF ICI
		haut.setPadding(new Insets(10,10,00,10));		// MODIF ICI
		
		haut.setStyle("-fx-background-color: #a5f6ff");
		haut.setPrefSize(1470,50);		// MODIF ICI
//		haut.setVgap(10);		// MODIF ICI
		haut.setHgap(15);		// MODIF ICI
		
// STAGIAIRE 1
		 ImageView selectedImage1 = new ImageView();   
	     Image image1 = new Image(Annuaire.class.getResourceAsStream("photoID.png"));
	     selectedImage1.setImage(image1);
	     selectedImage1.setFitWidth(50);		// MODIF ICI 
	     selectedImage1.setFitHeight(50);		// MODIF ICI
	     Text nomS1 = new Text("Deschamps");
	     nomS1.setFont(Font.font("Verdana",20));
	     Text prenomS1 = new Text ("Francis");
	     prenomS1.setFont(Font.font("Verdana",20));
	     Text depS1 = new Text ("93");
	     depS1.setFont(Font.font("Verdana",20));
	     infos1.getChildren().addAll(nomS1,prenomS1,depS1);
	     photoInfos1.getChildren().addAll(selectedImage1,infos1);
	     
//Stagiaire 2	     
	     
	     ImageView selectedImage2 = new ImageView();   
	     Image image2 = new Image(Annuaire.class.getResourceAsStream("photoID2.png"));
	     selectedImage2.setImage(image2);
	     selectedImage2.setFitWidth(50);		// MODIF ICI 
	     selectedImage2.setFitHeight(50);		// MODIF ICI
	     Text nomS2 = new Text("Sparrow");
	     nomS2.setFont(Font.font("Verdana",20));
	     Text prenomS2 = new Text ("Jack");
	     prenomS2.setFont(Font.font("Verdana",20));
	     Text depS2 = new Text ("92");
	     depS2.setFont(Font.font("Verdana",20));
	     infos2.getChildren().addAll(nomS2,prenomS2,depS2);
	     photoInfos2.getChildren().addAll(selectedImage2,infos2);
	     
	     
//AFFICHAGE MILIEU DE PAGE		// MODIF ICI
	     

	
	     bas.getChildren().addAll(photoInfos1);
	     bas.setStyle("-fx-background-color: #e2fdff");
	     bas1.getChildren().addAll(photoInfos2);
	     bas1.setStyle("-fx-background-color:#e2fdff");
	     bas.setPrefSize(1000,350);
	     bas1.setPrefSize(1000,350);
	    
//AFFICHAGE BAS DE PAGE		// MODIF ICI
	    rechercher.getChildren().addAll(btnRechercher,btnAdd);
	    rechercher.setPadding(new Insets(10));  // espace sous et au dessus de la HBox
	 	rechercher.setSpacing(10);
	    rechercher.setAlignment(Pos.CENTER);
	 	rechercher.setStyle("-fx-background-color:#a5f6ff");
	 	rechercher.setPrefSize(1000,50);
	 	
	 	btnBas.getChildren().addAll(btnImprimer,btnRetour);
	 	btnBas.setAlignment(Pos.BOTTOM_CENTER);
	 	btnBas.setSpacing(20);		// MODIF ICI
	 	btnBas.setStyle("-fx-background-color:#a5f6ff");
	 	btnBas.setPadding(new Insets (5));		// MODIF ICI
	 	btnBas.setPrefSize(1470,40);		// MODIF ICI
	     
//EVENEMENT
	     
	btnRetour.setOnAction(new EventHandler<ActionEvent>() {

		@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BienvenuF bienvenuF = new BienvenuF();
				Scene scene = new Scene(bienvenuF);
				Stage stage = (Stage)Annuaire.this.getScene().getWindow();
				stage.sizeToScene();
				stage.setScene(scene);
				
			} 
						
		});		
	
	
//ASSEMBLAGE TOTAL
		
		getChildren().addAll(titre,haut,rechercher,bas, bas1,btnBas);
		setPrefSize(1470, 755);		// MODIF ICI
	}
	
	


	


	public Text getNom() {
		return nom;
	}


	public void setNom(Text nom) {
		this.nom = nom;
	}


	public TextField getTnom() {
		return tNom;
	}


	public void setTnom(TextField tnom) {
		this.tNom = tnom;
	}


	public Text getPrenom() {
		return prenom;
	}


	public void setPrenom(Text prenom) {
		this.prenom = prenom;
	}


	public TextField getTprenom() {
		return tPrenom;
	}


	public void setTprenom(TextField tprenom) {
		this.tPrenom = tprenom;
	}


	public Text getDepartement() {
		return departement;
	}


	public void setDepartement(Text departement) {
		this.departement = departement;
	}


	public TextField getDep() {
		return dep;
	}


	public void setDep(TextField dep) {
		this.dep = dep;
	}


	public Text getPromo() {
		return promo;
	}


	public void setPromo(Text promo) {
		this.promo = promo;
	}


	public TextField getTpromo() {
		return tPromo;
	}


	public void setTpromo(TextField tpromo) {
		this.tPromo = tpromo;
	}


	public Text getAnnee() {
		return annee;
	}


	public void setAnnee(Text annee) {
		this.annee = annee;
	}


	public TextField getTannee() {
		return tAnnee;
	}


	public void setTannee(TextField tannee) {
		this.tAnnee = tannee;
	}


	public HBox getRechercher() {
		return rechercher;
	}


	public void setRechercher(HBox rechercher) {
		this.rechercher = rechercher;
	}


	public Button getBtnRechercher() {
		return btnRechercher;
	}


	public void setBtnRechercher(Button btnRechercher) {
		this.btnRechercher = btnRechercher;
	}
	
	public Button getBtnRetour() {
		return btnRetour;
	}


	public void setBtnRetour(Button btnRetour) {
		this.btnRetour = btnRetour;
	}

}
