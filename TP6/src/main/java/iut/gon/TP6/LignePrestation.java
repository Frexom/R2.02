package iut.gon.TP6;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LignePrestation extends Ligne{

	@ManyToOne Prestation prestation;
	
	public LignePrestation() {
		super();
	}
	
}
