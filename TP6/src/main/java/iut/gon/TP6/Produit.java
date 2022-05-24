package iut.gon.TP6;

import javax.persistence.Entity;


@Entity
public class Produit extends Element{


	public Produit(String titre, double prix) {

		super(titre, prix);	
	}
}	
