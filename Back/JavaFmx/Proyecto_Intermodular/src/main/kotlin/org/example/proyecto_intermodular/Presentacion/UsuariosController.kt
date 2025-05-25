package org.example.proyecto_intermodular.Presentacion

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.proyecto_intermodular.AccesoDatos.UsuarioDAO
import org.example.proyecto_intermodular.AccesoDatos.UsuarioDAOImpl
import org.example.proyecto_intermodular.Negocio.Usuario

class UsuariosController {
    @FXML
    private lateinit var comboUsuario: ComboBox<Usuario>
    @FXML
    private lateinit var txtIdUsuario: TextField
    @FXML
    private lateinit var txtTipo: TextField
    @FXML
    private lateinit var txtCorreo: TextField
    @FXML
    private lateinit var txtTlf: TextField
    @FXML
    private lateinit var txtContrasenia: TextField
    @FXML
    private lateinit var txtFechaAlta: TextField

    private val dao = UsuarioDAOImpl()

    private fun cargarUsuarios() {
        val lista = FXCollections.observableArrayList(dao.getAllUsuarios())
        comboUsuario.items = lista
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }

    private fun limpiarCampos() {
        txtIdUsuario.clear()
        txtTipo.clear()
        txtCorreo.clear()
        txtTlf.clear()
        txtContrasenia.clear()
        txtFechaAlta.clear()
        comboUsuario.selectionModel.clearSelection()
    }
    @FXML
    fun initialize() {
        cargarUsuarios()

        comboUsuario.setOnAction {
            val seleccionada = comboUsuario.selectionModel.selectedItem
            if (seleccionada != null) {
                txtIdUsuario.text = seleccionada.id_usuario.toString()
                txtTipo.text = seleccionada.tipo
                txtCorreo.text = seleccionada.correo
                txtTlf.text = seleccionada.tlf.toString()
                txtContrasenia.text = seleccionada.contrasenia
                txtFechaAlta.text = seleccionada.fecha_alta.toString()
            }
        }
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirUsuario(event: ActionEvent) {
        try {
            val nuevoID = dao.getAllUsuarios().maxOfOrNull { it.id_usuario }?.plus(1) ?: 1
            val tipo = txtTipo.text
            val correo = txtCorreo.text
            val tlf = txtTlf.text.toInt()
            val contrasenia = txtContrasenia.text
            val fechaAlta = txtFechaAlta.text.toInt()

            if (tipo.isBlank()) {
                mostrarAlerta("Advertencia", "El tipo no puede estar vacío.")
                return
            }

            if (correo.isBlank()) {
                mostrarAlerta("Advertencia", "El correo no puede estar vacío.")
                return
            }
            if (tlf == null) {
                mostrarAlerta("Advertencia", "El teléfono no puede estar vacio.")
                return
            }
            if (contrasenia.isBlank()) {
                mostrarAlerta("Advertencia", "La contraseña no puede estar vacía.")
                return
            }
            if (fechaAlta == null) {
                mostrarAlerta("Advertencia", "La fecha de alta no puede estar vacia.")
                return
            }

            if (dao.insertUsuario(Usuario(nuevoID, tipo, correo, tlf, contrasenia, fechaAlta))) {
                mostrarAlerta("Éxito", "Usuario añadido con PK $nuevoID.")
            } else {
                mostrarAlerta("Error", "No se pudo añadir el usuario.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun modificarUsuario(event: ActionEvent) {
        try {
            val id = txtIdUsuario.text.toInt()
            val tipo = txtTipo.text
            val correo = txtCorreo.text
            val tlf = txtTlf.text.toInt()
            val contrasenia = txtContrasenia.text
            val fechaAlta = txtFechaAlta.text.toInt()

            if (dao.updateUsuario(Usuario(id, tipo, correo, tlf, contrasenia, fechaAlta))) {
                mostrarAlerta("Éxito", "Usuario modificado correctamente.")
                cargarUsuarios()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar el usuario.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun borrarUsuario(event: ActionEvent) {
        try {
            val id = txtIdUsuario.text.toInt()

            if (dao.deleteUsuario(id)) {
                mostrarAlerta("Éxito", "Usuario borrado correctamente.")
                cargarUsuarios()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo borrar el usuario.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}