package iut.gon.TP6;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Facture{

	
	public static int counter = 0;
	
	@OneToMany(mappedBy="facture")
	private Set<Ligne> lignes;
	@OneToOne
	private Customer client;
	@Id
	private int id;

	
	public Facture(Customer c) {
		this.client = c;
		this.id = counter;
		counter++;
	}
	
}
