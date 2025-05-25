package org.example.proyecto_intermodular.Presentacion

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.control.ListView
import javafx.stage.Stage
import org.example.proyecto_intermodular.AccesoDatos.ReclutadorDAOImpl
import org.example.proyecto_intermodular.Negocio.Desarrollador
import org.example.proyecto_intermodular.Negocio.Reclutador

class ReclutadorController {
    @FXML
    private lateinit var cbReclutadores: ComboBox<Reclutador>

    @FXML
    private lateinit var listaReclutados: ListView<Desarrollador>

    @FXML
    fun initialize() {
        val DAO=ReclutadorDAOImpl()
        val listaReclutadores =DAO.getAllReclutadores()


        cbReclutadores.items = FXCollections.observableArrayList(listaReclutadores)


        cbReclutadores.setOnAction {
            val seleccionado = cbReclutadores.selectionModel.selectedItem
            if (seleccionado != null) {
                listaReclutados.items = FXCollections.observableArrayList(seleccionado.reclutados)

            }
        }
    }
    @FXML
    fun onVolver(event: ActionEvent?) {
        val source: Node = event!!.source as Node
        val stage = source.scene.window as Stage
        stage.close()
    }
}