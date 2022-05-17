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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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
	
	public void initGrille(String userData) {
		this.gridpane.getRowConstraints().clear();
		this.gridpane.getColumnConstraints().clear();
		int[] d = ModeleDemineur.parseUserData(userData);
		ModeleDemineur m = new ModeleDemineur(d[0], d[1], d[2]);
		
	     for (int i = 0; i < d[0]; i++) {
	         ColumnConstraints column = new ColumnConstraints(100);
	         column.setMaxWidth(32);
	         column.setMinWidth(32);
	         column.setPrefWidth(32);
	         gridpane.getColumnConstraints().add(column);
	         
	         RowConstraints row = new RowConstraints(100);
	         row.setMaxHeight(32);
	         row.setMinHeight(32);
	         row.setPrefHeight(32);
	         gridpane.getRowConstraints().add(row);
	     }
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		this.textinconnues.textProperty().bind(modele.nbInconnuesProperty().asString());
		this.textmarques.textProperty().bind(modele.nbMarquesProperty().asString());
		this.difficulty.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				initGrille((String) newValue.getUserData());

			}
		});
	}



}
