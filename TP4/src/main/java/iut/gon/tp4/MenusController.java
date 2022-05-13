package iut.gon.tp4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MenusController {

	private GrilleModel modele;
	private Scores scores;
	
	public MenusController() {
		
	}
	
	public void setParams(GrilleModel g, Scores s) {
		this.modele = g;
		this.scores = s;
	}
	
	
	@FXML
	public void onMenuNouvelle(ActionEvent evt) {
		modele.nouvellePartie();
	}
	@FXML
	public void onMenuTable(ActionEvent evt) {
		FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
		TableController tableC = fxmlLoader.getController();
		tableC.setScores(this.scores);

		//this.grille.getScene().setRoot();
	}

	@FXML
	public void onMenuQuitter(ActionEvent evt) {
		Platform.exit();
	}
	
}
