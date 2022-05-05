package iut.gon.TP3;

import javafx.scene.control.Label;

public class GrilleModel {
	private String[][] array = new String[3][3];

	public GrilleModel() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.array[i][j] = i + ", " + j;
			}	
		}
	}
	
	public String getCase(int ligne, int colonne) {
		return array[ligne][colonne];
	}
	
	public void setCase(int ligne, int colonne, String texte) {
		array[ligne][colonne] = texte;
	}
}
