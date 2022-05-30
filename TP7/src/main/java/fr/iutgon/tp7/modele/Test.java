package fr.iutgon.tp7.modele;

public class Test {
  public static void main(String[] args) {
    Produit p = new Produit("Lait", 0.72f, 1.05f);
    System.out.println(p);
    Ligne l = new Ligne(1, p);
    System.out.println(l);
    Ligne l2 = new Ligne(2, p);
    System.out.println(l2);
    p.setPrix(1f);
    System.out.println(l2);
  }
}
