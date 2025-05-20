package org.example.proyecto_intermodular.Utilidades

object SQL_Marta {
    const val SELECT_ALL_RECLUTADORES = "select * from usuario where upper(tipo) like 'RECLUTADOR'"
    const val SELECT_ALL_RECLUTADOS = "select * from usuario join reclutador on " +
            "usuario.id_usuario=reclutador.id_usuario join reclutamiento on " +
            "reclutador.id_usuario=reclutamiento.id_reclutador where id_usuario = ?'"
}