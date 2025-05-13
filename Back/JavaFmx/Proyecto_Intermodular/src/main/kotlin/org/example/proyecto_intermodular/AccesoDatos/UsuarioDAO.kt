package org.example.proyecto_intermodular.AccesoDatos

import org.example.proyecto_intermodular.Negocio.Usuario

interface UsuarioDAO {
    fun getUsuarioByID(id_usuario: Int): Usuario?
    fun getAllUsuarios(): List<Usuario>
    fun insertUsuario(usuario: Usuario): Boolean
    fun updateUsuario(usuario: Usuario): Boolean
    fun deleteUsuario(id_usuario: Int): Boolean
}