package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class DemineurController implements Initializable {

	@FXML
	private TextField textinconnues;
	@FXML
	private TextField textmarques;
	@FXML
	private ToggleGroup difficulty;
	@FXML
	private GridPane gridpane;
	private ModeleDemineur modele;


	public DemineurController() {

	}
	
	public void initGrille(int diff1, int diff2, int diff3) {
		this.gridpane.getRowConstraints().clear();
		this.gridpane.getColumnConstraints().clear();
		this.gridpane.getChildren().clear();
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		this.textinconnues.textProperty().bind(modele.nbInconnuesProperty().asString());
		this.textmarques.textProperty().bind(modele.nbMarquesProperty().asString());
		this.difficulty.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				String diff = (String) newValue.getUserData();
				int diff1 = Integer.valueOf(diff.substring(0,1));
				int diff2 = Integer.valueOf(diff.substring(3,4));
				int diff3 = Integer.parseInt(diff.substring(6));
				this.initGrille(diff1, diff2, diff3);

			}
		});
	}



}
