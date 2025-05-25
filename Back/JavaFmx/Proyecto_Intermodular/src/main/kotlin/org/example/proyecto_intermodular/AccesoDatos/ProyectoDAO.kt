package org.example.proyecto_intermodular.AccesoDatos

import org.example.proyecto_intermodular.Negocio.Proyecto
import org.example.proyecto_intermodular.Utilidades.ConexionBD

class ProyectoDAO {
    private val conexion = ConexionBD()

    fun getAllProyectos(): List<Proyecto> {
        val proyectos = mutableListOf<Proyecto>()
        val query = "SELECT id_proyecto, nombre, descripcion FROM proyecto"

        try {
            conexion.conectar()
            val stmt = conexion.getStatement()
            val rs = stmt?.executeQuery(query)

            while (rs?.next() == true) {
                proyectos.add(
                    Proyecto(
                        rs.getInt("id_proyecto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            conexion.desconectar()
        }
        return proyectos
    }

    fun getProyectoById(id: Int): Proyecto? {
        val query = "SELECT id_proyecto, nombre, descripcion FROM proyecto WHERE id_proyecto = ?"
        var proyecto: Proyecto? = null

        try {
            conexion.conectar()
            val pstmt = conexion.getPreparedStatement(query)
            pstmt?.setInt(1, id)
            val rs = pstmt?.executeQuery()

            if (rs?.next() == true) {
                proyecto = Proyecto(
                    rs.getInt("id_proyecto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            conexion.desconectar()
        }
        return proyecto
    }
}