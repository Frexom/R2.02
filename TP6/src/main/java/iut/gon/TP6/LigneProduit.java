package iut.gon.TP6;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LigneProduit extends Ligne{

	@ManyToOne Produit produit;
	
	public LigneProduit() {
		super();
	}
	
}
