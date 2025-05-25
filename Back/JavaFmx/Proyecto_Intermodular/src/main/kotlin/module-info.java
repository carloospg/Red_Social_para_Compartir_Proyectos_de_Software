module org.example.proyecto_intermodular {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.proyecto_intermodular to javafx.fxml;
    exports org.example.proyecto_intermodular;



    opens org.example.proyecto_intermodular.Presentacion to javafx.fxml;
    exports org.example.proyecto_intermodular.Presentacion;
}

