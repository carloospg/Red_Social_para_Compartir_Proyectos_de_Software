/*selects*/

/*saber los usuarios y la empresa en la que trabajan*/

select usuario.id_usuario, empresa.nombre from usuario
join gerente_proyecto
on usuario.id_usuario = gerente_proyecto.id_usuario
join empresa
on gerente_proyecto.id_empresa = empresa.id_empresa
order by usuario.id_usuario;

/*saber en que proyecto esta cada desarrollador*/

select proyecto.nombre, desarrollador.id_usuario from proyecto
join proyecto_des
on proyecto.id_proyecto = proyecto_des.id_proyecto
join desarrollador
on proyecto_des.id_desarrollador = desarrollador.id_usuario
order by proyecto.nombre;

/*el año en que los usuarios se dieron de alta*/

select extract(year from fecha_alta) as anio, id_usuario from usuario
order by anio;

/*el total de los comentarios que hay en los proyectos*/

select proyecto.nombre, count(comentario.id_comentario) as comentarios from proyecto
join coment_proyecto
on proyecto.id_proyecto = coment_proyecto.id_proyecto
join comentario
on coment_proyecto.id_comentario = comentario.id_comentario
group by proyecto.nombre
order by proyecto.nombre;