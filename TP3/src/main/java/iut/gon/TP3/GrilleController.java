package iut.gon.TP3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable {
	@FXML GridPane grille;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		grille.setStyle("-fx-background-color: red");
		
	}

  
}
