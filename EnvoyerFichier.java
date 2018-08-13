package IhmFinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnvoyerFichier extends BorderPane {
	
	private VBox centreV = new VBox();
	private Text txtAdresse = new Text(30,30,"Veuillez copier le path de votre fichier :");
	private TextField adresseAnnuaire = new TextField("Afficher");
	private Button btnSend = new Button("Envoyer");
	private Button btnRetour = new Button ("Retour");
	private BorderPane sendBack = new BorderPane();
	private HBox deco1 = new HBox();
	private HBox deco2 = new HBox();
	
	public EnvoyerFichier() {
		
		deco1.setPrefSize(1000, 50);
		deco1.setStyle("-fx-background-color:#e2fdff");
		deco2.setPrefSize(1000, 50);
		deco2.setStyle("-fx-background-color:#e2fdff");
		
		btnSend.setPadding(new Insets(10));
		adresseAnnuaire.setPrefSize(1, 30);
		
		txtAdresse.setFont(Font.font("Verdana",20));
		txtAdresse.setFill(Color.BLACK);
		
		sendBack.setCenter(btnSend);
		sendBack.setRight(btnRetour);
		centreV.getChildren().addAll(txtAdresse,adresseAnnuaire,sendBack);
		centreV.setAlignment(Pos.CENTER);
		centreV.setPadding(new Insets(10,20,20,10));
		centreV.setSpacing(10);
		
		
		setCenter(centreV);
		setTop(deco1);
		setBottom(deco2);
		setStyle("-fx-background-color: #a5f6ff");
		setPrefSize(1000,1000);
		
		btnRetour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BienvenuF bienvenuF = new BienvenuF();
				Scene scene = new Scene(bienvenuF);
				Stage stage = (Stage)EnvoyerFichier.this.getScene().getWindow();
				
				stage.setScene(scene);
				
			} 
			
			
		});		
	}

	public VBox getCentreV() {
		return centreV;
	}

	public void setCentreV(VBox centreV) {
		this.centreV = centreV;
	}

	public Text getTxtAdresse() {
		return txtAdresse;
	}

	public void setTxtAdresse(Text txtAdresse) {
		this.txtAdresse = txtAdresse;
	}

	public TextField getAdresseAnnuaire() {
		return adresseAnnuaire;
	}

	public void setAdresseAnnuaire(TextField adresseAnnuaire) {
		this.adresseAnnuaire = adresseAnnuaire;
	}

	public Button getBtnSend() {
		return btnSend;
	}

	public void setBtnSend(Button btnSend) {
		this.btnSend = btnSend;
	}
	

}
