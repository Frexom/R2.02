package fr.iutgon.tp7.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LigneTest {

  private Produit produit;
  private Ligne ligne;

  @BeforeEach
  public void prepare() {
    produit = new Produit("produit", 12.f, 1.1f);
    ligne = new Ligne(3, produit);
  }

  @Test
  public void newTest() {
    assertEquals(3, ligne.getQte());
    assertEquals(3, ligne.qteProperty().get());
    assertSame(produit, ligne.getProduit());
    assertSame(produit, ligne.produitProperty().get());
    ligne.setQte(5);
    assertEquals(5, ligne.getQte());
    assertEquals(5, ligne.qteProperty().get());
    Ligne ligne2 = new Ligne(3, produit);
    assertNotEquals(ligne2, ligne);
    assertEquals(5, ligne.getQte());
    assertEquals(5, ligne.qteProperty().get());
    ligne2.setQte(5);
    assertEquals(ligne2, ligne);
    Produit produit0 = FabriqueProduits.getProduits().get(0);
    ligne2 = new Ligne(3, produit0);
    assertSame(produit0, ligne2.getProduit());
    assertSame(produit0, ligne2.produitProperty().get());
    Produit produit1 = FabriqueProduits.getProduits().get(1);
    ligne.setProduit(produit1);
    assertSame(produit1, ligne.getProduit());
    assertSame(produit1, ligne.produitProperty().get());
    Produit produit2 = FabriqueProduits.getProduits().get(1);
    ligne.produitProperty().set(produit2);
    assertSame(produit1, ligne.getProduit());
    assertSame(produit1, ligne.produitProperty().get());
  }

  @Test
  public void mathTest() {
    assertEquals(36.f, ligne.getTotalHT());
    assertEquals(36.f, ligne.totalHTProperty().getValue().floatValue());
    assertEquals(36.f*1.1f, ligne.getTotalTTC());
    assertEquals(36.f*1.1f, ligne.totalTTCProperty().getValue().floatValue());
    produit.setPrix(10.f);
    assertEquals(30.f, ligne.getTotalHT());
    assertEquals(30.f, ligne.totalHTProperty().getValue().floatValue());
    assertEquals(30.f*1.1f, ligne.getTotalTTC());
    assertEquals(30.f*1.1f, ligne.totalTTCProperty().getValue().floatValue());
    ligne.setQte(10);
    assertEquals(100.f, ligne.getTotalHT());
    assertEquals(100.f, ligne.totalHTProperty().getValue().floatValue());
    assertEquals(100.f*1.1f, ligne.getTotalTTC());
    assertEquals(100.f*1.1f, ligne.totalTTCProperty().getValue().floatValue());
  }
}