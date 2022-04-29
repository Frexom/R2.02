module iut.gon.tp2 {
  requires javafx.controls;
  requires javafx.fxml;
requires javafx.base;

  opens iut.gon.tp2 to javafx.fxml;
  exports iut.gon.tp2;
}
