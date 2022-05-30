package fr.iutgon.tp7.modele;

import java.util.Objects;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/** Représente une ligne de facture */
public class Ligne {
  private final SimpleIntegerProperty qte;
  private final SimpleObjectProperty<Produit> produit;
  private final NumberExpression totalHT;
  private final NumberExpression totalTTC;

  /** Construit une ligne de facture */
  public Ligne(int qte, Produit produit) {
    this.qte = new SimpleIntegerProperty();
    this.qte.set(qte);
    this.produit = new SimpleObjectProperty<Produit>();
    this.setProduit(produit);
    
    this.totalHT = Bindings.multiply(this.qte, this.produit.get().prixProperty());
    this.totalTTC = Bindings.multiply(this.produit.get().getTva(), this.totalHT);
    this.totalHT.addListener((obs,ov,nv)->System.out.println(nv));
    
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Ligne) obj;
    return this.qte.get() == that.qte.get() && Objects.equals(this.produit.get(), that.produit.get());
  }

  /** Retourne le produit concerné par la ligne */
  public Produit getProduit() {
    return produit.get();
  }

  /** Modifie le produit concerné par la ligne */
  public void setProduit(Produit produit) {
    this.produit.set(produit);
  }

  /** Retourne la quantité de produits concernés par la ligne */
  public int getQte() {
    return qte.get();
  }

  /** Modifie la quantité de produits concernés par la ligne */
  public void setQte(int qte) {
    this.qte.set(qte);
  }

  /** La valeur totale Hors-Taxes de la ligne */
  public Number getTotalHT() {
    return totalHT.getValue();
  }

  /** La valeur totale Toutes-Taxes-Comprises de la ligne */
  public Number getTotalTTC() {
    return totalTTC.getValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(qte, produit);
  }

  /** Le produit concerné par la ligne */
  public SimpleObjectProperty<Produit> produitProperty() {
    return produit;
  }

  /** La quantité de produits concernés par la ligne */
public SimpleIntegerProperty qteProperty() {
    return qte;
  }

  @Override
  public String toString() {
    return String.format("Ligne[qte=%s, produit=%s, totalHT=%s, totalTTC=%s]", qte, produit.get(), totalHT.floatValue(), totalTTC.floatValue());
  }

  /** Le total Hors-Taxes de la ligne */
  public NumberExpression totalHTProperty() {
    return totalHT;
  }

  /** Le total Toutes-Taxes-Comprises de la ligne */
  public NumberExpression totalTTCProperty() {
    return totalTTC;
  }

} // public class Ligne
