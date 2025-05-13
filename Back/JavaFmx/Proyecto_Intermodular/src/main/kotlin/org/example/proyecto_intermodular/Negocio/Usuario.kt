package org.example.proyecto_intermodular.Negocio

class Usuario (val id_usuario: Int, val tipo: String, val correo: String, val tlf:Int, val contrasenia: String, val fecha_alta: Int){
    override fun toString(): String {
        return "Usuario: $id_usuario, $tipo, $correo, $tlf, $contrasenia, $fecha_alta"
    }
}