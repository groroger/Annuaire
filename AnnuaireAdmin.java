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

public class AnnuaireAdmin extends VBox {
	private VBox titre = new VBox();
	private GridPane haut = new GridPane();
	private VBox bas = new VBox();
	private VBox bas1 = new VBox();
	private HBox rechercher = new HBox();
	
	private HBox photoInfos = new HBox();
	private HBox photoInfos1 = new HBox();
	private VBox infos = new VBox();
	private VBox infos1 = new VBox();
	
	private HBox btnBas = new HBox();
	
//TEXT ET TEXTFIELD
	private Text titres = new Text("Annuaire des stagiaires :" );
	
	private Text nom = new Text("Nom " );
	private TextField tnom = new TextField("");
	private Text prenom = new Text ("Prénom " );
	private TextField tprenom = new TextField("");
	
	private Text departement = new Text ("Département  ");
	private TextField dep = new TextField ("");
	
	private Text promo = new Text ("Promotion");
	private TextField tpromo = new TextField();
	
	private Text annee = new Text ("Année");
	private TextField tannee = new TextField();
	
//BOUTONS
	private Button btnRechercher = new Button("Rechercher");
	private Button btnAdd = new Button("Ajouter");

	public Button btnRetour = new Button ("Retour");
	public Button btnSup = new Button ("Supprimer");
	public Button btnImprimer = new Button ("Imprimer");
	public Button btnMaj = new Button("Mettre à jour");
	


	public AnnuaireAdmin() {
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
				

		titre.getChildren().add(titres);
		titre.setAlignment(Pos.CENTER);
		titre.setStyle("-fx-background-color:#e2fdff");
		titres.setFont(Font.font("Verdana",40));
		
		
	
		haut.addRow(1,nom,tnom,prenom,tprenom,annee,cb);
		haut.addRow(2,departement,cb1,promo,tpromo);
		haut.setPadding(new Insets(20,20,00,10));
		
		haut.setStyle("-fx-background-color: #a5f6ff");
		haut.setPrefSize(1000,150);
		haut.setVgap(10);
		haut.setHgap(10);
		
// STAGIAIRE 1
		 ImageView selectedImage = new ImageView();   
	     Image image1 = new Image(Annuaire.class.getResourceAsStream("photoID.png"));
	     selectedImage.setImage(image1);
	     Text nomS = new Text("Deschamps");
	     nomS.setFont(Font.font("Verdana",20));
	     Text prenomS = new Text ("Francis");
	     prenomS.setFont(Font.font("Verdana",20));
	     Text depS = new Text ("93");
	     depS.setFont(Font.font("Verdana",20));
	     infos.getChildren().addAll(nomS,prenomS,depS);
	     photoInfos.getChildren().addAll(selectedImage,infos);
	     
//Stagiaire 2	     
	     
	     ImageView selectedImage1 = new ImageView();   
	     Image image2 = new Image(Annuaire.class.getResourceAsStream("photoID2.png"));
	     selectedImage1.setImage(image2);
	     Text nomS1 = new Text("Sparrow");
	     nomS1.setFont(Font.font("Verdana",20));
	     Text prenomS1 = new Text ("Jack");
	     prenomS1.setFont(Font.font("Verdana",20));
	     Text depS1 = new Text ("92");
	     depS1.setFont(Font.font("Verdana",20));
	     
//AFFICHAGE BAS DE PAGE     
	     
	     infos1.getChildren().addAll(nomS1,prenomS1,depS1);
	     photoInfos1.getChildren().addAll(selectedImage1,infos1);
	
	     bas.getChildren().addAll(photoInfos);
	     bas.setStyle("-fx-background-color: #e2fdff");
	     bas1.getChildren().addAll(photoInfos1);
	     bas1.setStyle("-fx-background-color:#e2fdff");
	     bas.setPrefSize(1000,350);
	     bas1.setPrefSize(1000,350);
	    
	     
	    rechercher.getChildren().addAll(btnRechercher,btnAdd);
	    rechercher.setPadding(new Insets(10));  // espace sous et au dessus de la HBox
	 	rechercher.setSpacing(10);
	    rechercher.setAlignment(Pos.CENTER);
	 	rechercher.setStyle("-fx-background-color:#a5f6ff");
	 	rechercher.setPrefSize(1000,50);
	 	
	 	btnBas.getChildren().addAll(btnMaj,btnSup,btnImprimer,btnRetour);
	 	btnBas.setAlignment(Pos.BOTTOM_CENTER);
	 	btnBas.setSpacing(10);
	 	btnBas.setStyle("-fx-background-color:#a5f6ff");
	 	btnBas.setPadding(new Insets (20));
	 	btnBas.setPrefSize(1000,100);
	     
//EVENEMENT
	     
	btnRetour.setOnAction(new EventHandler<ActionEvent>() {

		@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BienvenuF bienvenuF = new BienvenuF();
				Scene scene = new Scene(bienvenuF);
				Stage stage = (Stage)AnnuaireAdmin.this.getScene().getWindow();
				stage.sizeToScene();
				stage.setScene(scene);
				
			} 
						
		});		
	
	
//ASSEMBLAGE TOTAL
		
		getChildren().addAll(titre,haut,rechercher,bas, bas1,btnBas);
		setPrefSize(1000,1000);
	}
	
	


	


	public Text getNom() {
		return nom;
	}


	public void setNom(Text nom) {
		this.nom = nom;
	}


	public TextField getTnom() {
		return tnom;
	}


	public void setTnom(TextField tnom) {
		this.tnom = tnom;
	}


	public Text getPrenom() {
		return prenom;
	}


	public void setPrenom(Text prenom) {
		this.prenom = prenom;
	}


	public TextField getTprenom() {
		return tprenom;
	}


	public void setTprenom(TextField tprenom) {
		this.tprenom = tprenom;
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
		return tpromo;
	}


	public void setTpromo(TextField tpromo) {
		this.tpromo = tpromo;
	}


	public Text getAnnee() {
		return annee;
	}


	public void setAnnee(Text annee) {
		this.annee = annee;
	}


	public TextField getTannee() {
		return tannee;
	}


	public void setTannee(TextField tannee) {
		this.tannee = tannee;
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
