package org.example.proyecto_intermodular.AccesoDatos

import org.example.proyecto_intermodular.Negocio.Desarrollador
import org.example.proyecto_intermodular.Negocio.Reclutador
import org.example.proyecto_intermodular.Utilidades.ConexionBD
import org.example.proyecto_intermodular.Utilidades.SQL_Marta

class ReclutadorDAOImpl:ReclutadorDAO {
    private val conexion = ConexionBD()

    override fun getAllReclutados(id_reclutador:Int): ArrayList<Desarrollador> {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Marta.SELECT_ALL_RECLUTADOS)
        ps?.setInt(1, id_reclutador)
        val rs = ps?.executeQuery()

        val reclutados = ArrayList<Desarrollador>()
        while (rs?.next() == true) {
            val reclutado = Desarrollador(
                rs.getInt("id_usuario"),
                rs.getString("tipo"),
                rs.getString("correo_electronico"),
                rs.getInt("telefono"),
                rs.getString("contrasenia"),
                rs.getInt("fecha_alta")
            )
            reclutados.add(reclutado)
        }
        ps?.close()
        conexion.desconectar()
        return reclutados
    }

    override fun getAllReclutadores(): List<Reclutador> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Marta.SELECT_ALL_RECLUTADORES)
        val reclutadores = mutableListOf<Reclutador>()
        while (rs?.next() == true) {
            val reclutador = Reclutador(
                rs.getInt("id_usuario"),
                rs.getString("tipo"),
                rs.getString("correo_electronico"),
                rs.getInt("telefono"),
                rs.getString("contrasenia"),
                rs.getInt("fecha_alta"),
                getAllReclutados(rs.getInt("id_usuario"))
            )
                reclutadores.add(reclutador)
        }
        st?.close()
        conexion.desconectar()
        return reclutadores
    }
}