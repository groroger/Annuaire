package IhmFinal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import IhmFinal.BienvenuF;


public class TestTransition extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		BienvenuF root = new BienvenuF();
		
		
		Scene scene = new Scene(root, 1470, 755);		// MODIF ICI
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setTitle("Annuaire des stagiaires");		// MODIF ICI
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
