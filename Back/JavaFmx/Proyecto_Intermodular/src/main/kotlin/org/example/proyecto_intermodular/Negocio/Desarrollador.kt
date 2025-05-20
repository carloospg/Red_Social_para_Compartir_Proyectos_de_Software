package org.example.proyecto_intermodular.Negocio

class Desarrollador:Usuario {
    var especialidad=""
    var github=""

    constructor(
        id_usuario: Int,
        tipo: String,
        correo: String,
        tlf: Int,
        contrasenia: String,
        fecha_alta: Int,
        especialidad: String,
        github: String
    ) : super(id_usuario, tipo, correo, tlf, contrasenia, fecha_alta) {
        this.especialidad = especialidad
        this.github = github
    }

    constructor(id_usuario: Int, tipo: String, correo: String, tlf: Int, contrasenia: String, fecha_alta: Int) : super(
        id_usuario,
        tipo,
        correo,
        tlf,
        contrasenia,
        fecha_alta
    )


}