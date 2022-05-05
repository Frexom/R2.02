module iut.gon.TP3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.TP3 to javafx.fxml;
    exports iut.gon.TP3;
}
