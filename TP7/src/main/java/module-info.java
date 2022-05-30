module fr.iutgon.tp7 {
  requires javafx.controls;
  requires javafx.fxml;
requires javafx.base;


  opens fr.iutgon.tp7 to javafx.fxml;
  exports fr.iutgon.tp7;
  exports fr.iutgon.tp7.modele;
}