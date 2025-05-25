package org.example.proyecto_intermodular

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "Pantalla Principal"
        stage.scene = scene
        stage.show()
        stage.setOnCloseRequest { event ->
            val alert = Alert(Alert.AlertType.CONFIRMATION)
            alert.title = "Confirmación de salida"
            alert.headerText = "¿Estás seguro de que quieres salir?"


            val result = alert.showAndWait()
            if (result.isPresent && result.get() != ButtonType.OK) {
                event.consume()
            }
        }

    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}