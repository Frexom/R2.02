package iut.gon.TP6;

import javax.persistence.Entity;

@Entity
public class Prestation extends Element{

	private double tva;

	public Prestation(String titre, double prix, double tva) {
		
		super(titre, prix);	
		this.tva = tva;
	}
}
