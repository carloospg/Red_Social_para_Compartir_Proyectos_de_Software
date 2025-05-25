package org.example.proyecto_intermodular.Negocio

class Reclutador :Usuario{
    var reclutados=ArrayList<Desarrollador>()

    constructor(id_usuario: Int, tipo: String, correo: String, tlf: Int, contrasenia: String, fecha_alta: Int) : super(
        id_usuario,
        tipo,
        correo,
        tlf,
        contrasenia,
        fecha_alta
    )

    constructor(
        id_usuario: Int,
        tipo: String,
        correo: String,
        tlf: Int,
        contrasenia: String,
        fecha_alta: Int,
        listaReclutados: ArrayList<Desarrollador>
    ) : super(id_usuario, tipo, correo, tlf, contrasenia, fecha_alta) {
        this.reclutados = listaReclutados
    }

    override fun toString(): String {
        return "Reclutador $id_usuario, $correo"
    }


}