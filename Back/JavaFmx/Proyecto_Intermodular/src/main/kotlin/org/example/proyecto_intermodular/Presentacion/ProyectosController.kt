package org.example.proyecto_intermodular.controladores

import javafx.fxml.FXML
import javafx.scene.control.TableView
import org.example.proyecto_intermodular.AccesoDatos.ProyectoDAO
import org.example.proyecto_intermodular.Negocio.Proyecto

class ProyectosController {
    @FXML
    private lateinit var tablaProyectos: TableView<Proyecto>

    private val proyectoDAO = ProyectoDAO()

    @FXML
    fun initialize() {
        val proyectos = proyectoDAO.getAllProyectos()
        tablaProyectos.items.addAll(proyectos)
    }
}