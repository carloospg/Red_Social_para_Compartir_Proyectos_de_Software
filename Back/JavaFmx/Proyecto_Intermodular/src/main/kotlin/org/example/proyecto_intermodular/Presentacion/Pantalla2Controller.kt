package org.example.proyecto_intermodular.Presentacion

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.ListView
import org.example.proyecto_intermodular.AccesoDatos.ReclutadorDAOImpl
import org.example.proyecto_intermodular.Negocio.Reclutador

class Pantalla2Controller {
    @FXML
    private lateinit var cbReclutadores: ComboBox<Reclutador>

    @FXML
    private lateinit var listaReclutados: ListView<String>

    @FXML
    fun initialize() {
        val DAO=ReclutadorDAOImpl()
        val listaReclutadores =DAO.getAllReclutadores()


        cbReclutadores.items = FXCollections.observableArrayList(listaReclutadores)


        cbReclutadores.setOnAction {
            val seleccionado = cbReclutadores.selectionModel.selectedItem
            if (seleccionado != null) {
                listaReclutados.items = FXCollections.observableArrayList(seleccionado.reclutados.toString())
            }
        }
    }
}