package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Morpion extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("grille.fxml"));

		Scores score = new Scores();
		GrilleController controller = new GrilleController(score);
		fxmlLoader.setController(controller);
		Scene scene = new Scene(fxmlLoader.load(), 800, 600);

		stage.setTitle("Morpion!");
		stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> switchMethod(event.getText(), controller));
		stage.setScene(scene);
		stage.show();
	}

	public void switchMethod(String s, GrilleController controller) {
		switch (s) {
		case "1" : controller.joueCase(2,0); break;
		case "2" : controller.joueCase(2,1); break;
		case "3" : controller.joueCase(2,2); break;
		case "4" : controller.joueCase(1,0); break;
		case "5" : controller.joueCase(1,1); break;
		case "6" : controller.joueCase(1,2); break;
		case "7" : controller.joueCase(0,0); break;
		case "8" : controller.joueCase(0,1); break;
		case "9" : controller.joueCase(0,2); break;
		}
	}

	public static void main(String[] args) {
		launch();
	}
}
