package iut.gon.TP6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Element {
	
	public static int counter = 0;
	
	@Id
	private int id;
	private String titre;
	private double prix;
	
	public Element(String titre, double prix) {
		counter++;
		
		this.id = counter;
		this.titre = titre;
		this.prix = prix;
	}

}
