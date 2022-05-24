package iut.gon.TP6;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Ligne {

	@ManyToOne Facture facture;
	public static int counter = 0;
	
	@Id
	private int id;
	
	public Ligne() {
		
		this.id = counter;
	
		counter++;
	}

}