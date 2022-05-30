package fr.iutgon.tp7;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import fr.iutgon.tp7.modele.Ligne;
import fr.iutgon.tp7.modele.Produit;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class FactureController implements Initializable {
	public TableView<Ligne> table;
	public TableColumn<Ligne, Integer> qte;
	public TableColumn<Ligne, Produit> produit;
	public TableColumn<Ligne, Number> prixUnitaire;
	public TableColumn<Ligne, Number> totalHT;
	public TableColumn<Ligne, Number> totalTTC;
	public TextField sommeFacture;

	/**
   Called to initialize a controller after its root element has been completely processed.

   @param location  The location used to resolve relative paths for the root object, or
   {@code null} if the location is not known.
   @param resources The resources used to localize the root object, or {@code null} if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
		totalHT.setCellValueFactory(new PropertyValueFactory<>("TotalHT"));
		totalTTC.setCellValueFactory(new PropertyValueFactory<>("TotalTTC"));
		
		Callback<TableColumn.CellDataFeatures<Ligne, Produit>, ObservableValue<Produit>> callbackProduit = new Callback<TableColumn.CellDataFeatures<Ligne, Produit>, ObservableValue<Produit>>(){

			@Override
			public ObservableValue<Produit> call(CellDataFeatures<Ligne, Produit> param) {

				return param.getValue().produitProperty();
			};
		};
		this.produit.setCellValueFactory(callbackProduit);

		Callback<TableColumn.CellDataFeatures<Ligne, Number>, ObservableValue<Number>> callbackPrix = new Callback<TableColumn.CellDataFeatures<Ligne, Number>, ObservableValue<Number>>(){

			@Override
			public ObservableValue<Number> call(CellDataFeatures<Ligne, Number> param) {

				return param.getValue().getProduit().prixProperty();
			};
		};
		this.prixUnitaire.setCellValueFactory(callbackPrix);
		
	}

	public void onAjouter(ActionEvent actionEvent) {
		Random rand = new Random();
		Produit p = new Produit("Table Ikea", rand.nextInt()%1000, rand.nextFloat()%2);
		Ligne l = new Ligne(rand.nextInt(50), p);

		this.table.getItems().add(l);
	}
}
