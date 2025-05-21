package org.example.proyecto_intermodular.Utilidades

object SQL_Marta {
    const val SELECT_ALL_RECLUTADORES = "select * from usuario where upper(tipo) like 'RECLUTADOR'"
    const val SELECT_ALL_RECLUTADOS =
        "SELECT " +
                "    desarrollador.id_usuario, " +
                "    usuario.tipo, " +
                "    usuario.correo_electronico, " +
                "    usuario.telefono, " +
                "    usuario.contrasenia, " +
                "    usuario.fecha_alta, " +
                "    desarrollador.github, " +
                "    desarrollador.especialidad " +
                "FROM " +
                "    reclutamiento " +
                "JOIN desarrollador ON reclutamiento.id_desarrollador = desarrollador.id_usuario " +
                "JOIN usuario ON desarrollador.id_usuario = usuario.id_usuario " +
                "JOIN reclutador ON reclutamiento.id_reclutador = reclutador.id_usuario " +
                "WHERE " +
                "    reclutador.id_usuario = ? " +
                "LIMIT 0, 25;";


}