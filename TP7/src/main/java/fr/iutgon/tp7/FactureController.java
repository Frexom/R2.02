package fr.iutgon.tp7;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import fr.iutgon.tp7.modele.FabriqueProduits;
import fr.iutgon.tp7.modele.Ligne;
import fr.iutgon.tp7.modele.Produit;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

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
		qte.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		produit.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Produit>() {

			@Override
			public String toString(Produit p) {
				return p.getNom();
			}

			@Override
			public Produit fromString(String string) {
				for(Produit p : FabriqueProduits.getProduits()) {
					if(string.contentEquals(p.getNom())) {
						return p;
					}
				}
				return null;
			}
			
		}, FXCollections.observableArrayList(FabriqueProduits.getProduits())));
		
		
		
		//totalHT.setCellValueFactory(new PropertyValueFactory<>("TotalHT"));
		totalHT.setCellValueFactory(param->param.getValue().totalHTProperty());
		totalTTC.setCellValueFactory(param->param.getValue().totalTTCProperty());
		
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
		List<Produit> listeProduits = FabriqueProduits.getProduits();
		Ligne l = new Ligne(rand.nextInt(50), listeProduits.get(rand.nextInt(listeProduits.size()-1)));

		this.table.getItems().add(l);
	}
}
