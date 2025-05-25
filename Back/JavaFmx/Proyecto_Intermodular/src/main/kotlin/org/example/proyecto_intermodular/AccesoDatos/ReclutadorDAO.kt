package org.example.proyecto_intermodular.AccesoDatos

import org.example.proyecto_intermodular.Negocio.Desarrollador
import org.example.proyecto_intermodular.Negocio.Reclutador

interface ReclutadorDAO {
    fun getAllReclutadores(): List<Reclutador>
    fun getAllReclutados(id_reclutador:Int): ArrayList<Desarrollador>
}