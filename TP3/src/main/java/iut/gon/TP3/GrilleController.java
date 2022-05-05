package iut.gon.TP3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable {
	@FXML GridPane grille;
	private Label[][] LabelArray = new Label[3][3];
	private GrilleModel model;
	
	
	public GrilleController(GrilleModel g) {
		this.model = g;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grille.setStyle("-fx-background-color: red");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				LabelArray[i][j] = new Label(this.model.getCase(i, j));
				LabelArray[i][j].setMaxSize(1000, 1000);
				LabelArray[i][j].setAlignment(Pos.CENTER);
				
				
				int a = i;
				int b = j;
				
				LabelArray[a][b].setOnMouseClicked(e -> {
					this.LabelArray[a][b].setText("Bonjour!");
				});
				
				grille.add(LabelArray[i][j], i, j);
			}
		}
		
	}

  
}
