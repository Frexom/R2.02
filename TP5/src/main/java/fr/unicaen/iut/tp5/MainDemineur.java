package fr.unicaen.iut.tp5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDemineur extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(MainDemineur.class.getResource("Grille.fxml"));
		DemineurController control = new DemineurController();
		fxmlLoader.setController(control);
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.show();
	}
}
