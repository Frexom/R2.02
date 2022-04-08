module iut.gon.TP1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.TP1 to javafx.fxml;
    exports iut.gon.TP1;
}
