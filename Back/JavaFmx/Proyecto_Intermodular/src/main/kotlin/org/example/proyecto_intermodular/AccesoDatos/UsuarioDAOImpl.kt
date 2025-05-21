package org.example.proyecto_intermodular.AccesoDatos

import org.example.proyecto_intermodular.AccesoDatos.UsuarioDAO
import org.example.proyecto_intermodular.Negocio.Usuario
import org.example.proyecto_intermodular.Utilidades.ConexionBD
import org.example.proyecto_intermodular.Utilidades.SQL_Carlos

class UsuarioDAOImpl: UsuarioDAO {
    private val conexion = ConexionBD()

    override fun getUsuarioByID(id_usuario: Int): Usuario? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Carlos.SELECT_USUARIO_BY_ID)
        val rs = ps?.executeQuery()
        var usuario: Usuario? = null
        if (rs?.next() == true) {
            usuario = Usuario(
                rs.getInt("id_usuario"),
                rs.getString("tipo"),
                rs.getString("correo"),
                rs.getInt("tlf"),
                rs.getString("contrasenia"),
                rs.getInt("fecha_alta")
            )
        }
        ps?.close()
        conexion.desconectar()
        return usuario
    }

    override fun getAllUsuarios(): List<Usuario> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Carlos.SELECT_ALL_USUARIOS)
        val usuarios = mutableListOf<Usuario>()
        while (rs?.next() == true) {
            val usuario = Usuario(
                rs.getInt("id_usuario"),
                rs.getString("tipo"),
                rs.getString("correo"),
                rs.getInt("tlf"),
                rs.getString("contrasenia"),
                rs.getInt("fecha_alta")
            )
            usuarios.add(usuario)
        }
        st?.close()
        conexion.desconectar()
        return usuarios
    }

    override fun updateUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Carlos.UPDATE_USUARIO)
        ps?.setString(1, usuario.tipo)
        ps?.setString(2, usuario.correo)
        ps?.setInt(3, usuario.tlf)
        ps?.setString(4, usuario.contrasenia)
        ps?.setInt(5, usuario.fecha_alta)
        ps?.setInt(6, usuario.id_usuario)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun insertUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Carlos.INSERT_USUARIO)
        ps?.setInt(1, usuario.id_usuario)
        ps?.setString(2, usuario.tipo)
        ps?.setString(3, usuario.correo)
        ps?.setInt(4, usuario.tlf)
        ps?.setString(5, usuario.contrasenia)
        ps?.setInt(6, usuario.fecha_alta)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteUsuario(id_usuario: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Carlos.DELETE_USUARIO)
        ps?.setInt(1, id_usuario)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}