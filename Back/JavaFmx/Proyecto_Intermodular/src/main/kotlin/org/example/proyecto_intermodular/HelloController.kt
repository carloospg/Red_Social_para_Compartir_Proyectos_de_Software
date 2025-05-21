package org.example.proyecto_intermodular

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.stage.Stage
import org.example.proyecto_intermodular.Presentacion.*

class HelloController {
    @FXML
    private lateinit var welcomeText: Label


    @FXML
    fun onBtReclutador(event: ActionEvent) {

        try {
            //val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
            val loader = FXMLLoader(ReclutadorController::class.java.getResource("/org/example/proyecto_intermodular/reclutador-view.fxml"))

            //val loader = FXMLLoader(javaClass.getResource("/com/example/debbddajavafx/categorias-view.fxml"))
            val root: Parent = loader.load() //El root es el padre es la ventana principal
            val stage = Stage()
            stage.scene = Scene(root)
            stage.title = "Reclutamientos"
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun onBtUsuarios(event: ActionEvent){
        try {
            val loader = FXMLLoader(UsuariosController::class.java.getResource("/org/example/proyecto_intermodular/usuarios-view.fxml"))
            val root: Parent = loader.load()
            val stage = Stage()
            stage.scene = Scene(root)
            stage.title = "Pantalla 3"
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    @FXML
    fun onSalir(event: ActionEvent) {
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "Confirmación de salida"
        alert.headerText = "¿Estás seguro de que quieres salir?"

        val result = alert.showAndWait()
        if (result.isPresent && result.get() == ButtonType.OK) {
            val node = event.source as javafx.scene.Node
            val stage = node.scene.window as javafx.stage.Stage
            stage.close()
        }
    }


}