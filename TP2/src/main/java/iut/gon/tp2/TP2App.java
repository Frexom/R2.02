package iut.gon.tp2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class TP2App extends Application {

	private BorderPane contenu;
	private ListView<String> gauche;
	private ListView<String> droite;
	private Button versGauche;
	private Button versDroite;
	private Button retireTout;
	private Button ajouteTout;
	private Menu menuFichiers;
	private Menu menuAide;
	private MenuItem itemQuitter;
	private MenuItem itemApropos;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(TP2App.class.getResource("Tp2.fxml"));
		contenu = fxmlLoader.load();
		Scene scene = new Scene(contenu);
		extraitIds(scene);

		prepareMenus((MenuBar) scene.lookup("#menus"));
		prepareListe();
		prepareBoutons();
		prepareFermeture(stage);

		stage.setTitle("Gestion de groupe");
		stage.setScene(scene);
		stage.show();
	}

	/** Prépare la fenêtre pour demander confirmation avant fermeture */
	private void prepareFermeture(Stage stage) {
		stage.setOnCloseRequest(event -> {
			//TODO confirmer ou consommer l'événement
			Alert alerte = new Alert(AlertType.CONFIRMATION);
			alerte.getButtonTypes().setAll(ButtonType.NO, ButtonType.YES);
			alerte.setTitle("Alerte!!!!?!!!! ");
			alerte.setContentText("Voulez-vous vraiment fermer la fenêtre?");
			if(alerte.showAndWait().get() == ButtonType.YES) {
				Platform.exit();
			}
			else {
				event.consume();
			}
		});
	}

	/** Prépare les actions des boutons */
	private void prepareBoutons() {
		this.ajouteTout.setOnAction(this::onAjouteTout);
		this.retireTout.setOnAction(this::onRetireTout);
		this.ajouteTout.setDisable(false);
		this.retireTout.setDisable(false);
		
		//actions des deux boutons centraux
		
		versDroite.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = gauche.getSelectionModel().getSelectedIndex();
				if(index > -1) {
					droite.getItems().add(gauche.getItems().remove(index));
					gauche.getSelectionModel().clearSelection();
				}
				
			}
			
		});
		
		versGauche.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = droite.getSelectionModel().getSelectedIndex();
				if(index > -1) {
					gauche.getItems().add(droite.getItems().remove(index));
					droite.getSelectionModel().clearSelection();
				}
				
			}
			
		});
	}
	

	/** Ajoute tous les éléments de gauche dans la liste de droite
   Active le bouton "Retirer tout" et désactive le bouton "Ajouter tout" */
	private void onAjouteTout(ActionEvent actionEvent) {
		
		droite.getItems().addAll(gauche.getItems());
		gauche.getItems().clear();
		
		gauche.setDisable(true);
		droite.setDisable(false);
	}

	
	/** Ajoute tous les éléments de droite dans la liste de gauche
   Active le bouton "Ajouter tout" et désactive le bouton "Retirer tout" */
	private void onRetireTout(ActionEvent actionEvent) {
		gauche.getItems().addAll(droite.getItems());
		droite.getItems().clear();
		
		droite.setDisable(true);
		gauche.setDisable(false);
	}

	/** Prépare les menus et leurs événements */
	private void prepareMenus(MenuBar menus) {

		this.menuFichiers = new Menu("_Fichiers");
		this.menuAide = new Menu("_Aide");
		this.itemQuitter = new MenuItem("Quitter");
		this.itemApropos = new MenuItem("À propos");



		itemQuitter.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();

			}

		});
		
		itemApropos.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alerte = new Alert(null,"Fermer", ButtonType.CLOSE);
				alerte.setTitle("À propos");
				alerte.setContentText("J'aime le pain");
				alerte.show();
			}

		});
		
		
		this.menuFichiers.getItems().add(this.itemQuitter);
		this.menuAide.getItems().add(this.itemApropos);
		
		

		menus.getMenus().addAll(this.menuFichiers, this.menuAide);
	}

	
	/**
   Remplit la liste de gauche avec des valeurs
   Active le bouton "Ajouter tout"
	 */
	private void prepareListe() {
		//TODO active le bouton "Ajouter tout"
		this.gauche.getItems().add("Patrick Starfish");
		this.gauche.getItems().add("Jotaro Kujo");
		this.gauche.getItems().add("Electric Man");
	}

	private void extraitIds(Scene scene) {
		gauche = (ListView<String>) scene.lookup("#gauche");
		droite = (ListView<String>) scene.lookup("#droite");
		versGauche = (Button) scene.lookup("#versGauche");
		versDroite = (Button) scene.lookup("#versDroite");
		retireTout = (Button) scene.lookup("#retireTout");
		ajouteTout = (Button) scene.lookup("#ajouteTout");
	}

	public static void main(String[] args) {
		launch();
	}
}
