package fr.iutgon.tp7.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Fabrique à produits */
public class FabriqueProduits {
	private static List<Produit> produits;

	public static List<Produit> getProduits() {
		Random rand= new Random();
		if (produits == null) {
			produits = new ArrayList<>();
			produits.add(new Produit("Crayon", 0.17f, 1.05f));
			produits.add(new Produit("Burger", 2.75f, 1.15f));
			produits.add(new Produit("Bijou", 123.45f, 1.33f));
			produits.add(new Produit("Table Ikea", rand.nextInt(1000), rand.nextFloat()%2));
			produits.add(new Produit("Promotion", -15.00f,1f));
		}
		return produits;
	}
}
