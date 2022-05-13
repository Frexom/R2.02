package iut.gon.tp4;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import iut.gon.tp4.Scores.Entree;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class GrilleController implements Initializable {

	private GrilleModel modele;
	private Scores scores;
	private MenusController menus;

	public GrilleController(Scores s) {
		this.modele =  new GrilleModel();
		this.menus = new MenusController();
		this.scores = s;
		
	}

	private @FXML GridPane grille;
	private @FXML HBox statut;
	private @FXML Label joueur;

	private Label[][] contenu = new Label[3][3];


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grille.setStyle("-fx-background-color: seashell");
		for (int l=0; l<3; ++l)
			for (int c=0; c<3; ++c) {
				Label label =new Label();
				label.textProperty().bind(modele.getCase(l,c));
				grille.add(label, c, l);
				int lg = l;
				int col = c;
				label.setOnMouseClicked(event -> this.joueCase(lg, col));
				label.setMaxSize(1000,1000);
				label.setAlignment(Pos.CENTER);
				label.setFont(Font.font(24));
			}
		joueur.textProperty().bind(modele.texteJoueur);
		this.menus.setParams(this.modele, this.scores);
	}

	public void joueCase(int lg, int col) {
		if (modele.estFinie()) return;
		try {
			modele.joueCase(lg, col);
		} catch (IllegalStateException ex) {
			new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
			return;
		}
		if (modele.estGagne(modele.JOUEUR_X))
			onGagne(modele.JOUEUR_X);
		else if (modele.estGagne(modele.JOUEUR_O))
			onGagne(modele.JOUEUR_O);
		else if (modele.estFinie())
			onGagne(null);
	}

	private void onGagne(String joueur) {
		if(joueur != null) {
			TextInputDialog win = new TextInputDialog(joueur);
			win.setTitle("Congratulations!");
			win.setHeaderText("Enter your name : ");
			win.setContentText("Name");
			Optional<String> name = win.showAndWait();
			if(!name.isEmpty()) {
				this.scores.ajouteVictoire(name.get());
			}
			else {
				this.scores.ajouteVictoire("joueur " + joueur);
			}
			String s = "";
			for(Entree e : this.scores.getScores()) {
				s += e.getJoueur() + " : " + e.getVictoires() + "\n";
			}
			s += "Nulles : " + this.scores.getNulles();
			
			Alert displayScores = new Alert(AlertType.NONE);
			displayScores.setContentText(s);
			displayScores.setHeaderText("Table des scores : ");
			displayScores.getDialogPane().getButtonTypes().add(ButtonType.OK);
			displayScores.showAndWait();
		}
		else {
			this.scores.ajouteNulle();
		}
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
