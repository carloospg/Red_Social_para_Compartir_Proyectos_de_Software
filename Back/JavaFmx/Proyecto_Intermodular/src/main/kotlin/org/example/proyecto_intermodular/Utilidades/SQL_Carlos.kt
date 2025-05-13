package org.example.proyecto_intermodular.Utilidades

object SQL_Carlos {

    const val SELECT_ALL_USUARIOS = "select * from usuario"
    const val SELECT_USUARIO_BY_ID = "select * from usuario where id_usuario = ?"
    const val INSERT_USUARIO = "insert into usuario (id_usuario, tipo, correo, tlf, contrasenia, fecha_alta) values (?, ?, ?, ?, ?, ?)"
    const val UPDATE_USUARIO = "update usuario set tipo = ?, correo = ?, tlf = ?, contrasenia = ?, fecha_alta = ? where id_usuario = ?"
    const val DELETE_USUARIO = "delete from usuario where id_usuario = ?"
}