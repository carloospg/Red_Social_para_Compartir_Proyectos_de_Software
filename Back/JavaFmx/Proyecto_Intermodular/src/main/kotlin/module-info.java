module org.example.proyecto_intermodular {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.proyecto_intermodular to javafx.fxml;
    exports org.example.proyecto_intermodular;
}