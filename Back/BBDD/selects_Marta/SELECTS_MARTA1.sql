--Select de Marta para entender mejor la BBDD

-- Obtener todos los desarrolladores con su especialidad y su GitHub
select usuario.id_usuario, usuario.correo_electronico, desarrollador.especialidad, desarrollador.github
from desarrollador 
join usuario on desarrollador.id_usuario = usuario.id_usuario;

-- Obtener los proyectos que lleva cada empresa 
select empresa.nombre, count(proyecto.id_proyecto)
from empresa
join gerente_proyecto on empresa.id_empresa = gerente_proyecto.id_empresa
join proyecto_des on gerente_proyecto.id_usuario = proyecto_des.id_desarrollador
join proyecto on proyecto_des.id_proyecto = proyecto.id_proyecto
group by empresa.nombre;


-- Obtener los proyectos de un desarrollador específico
select proyecto.nombre, proyecto.descripcion
from proyecto
join proyecto_des on proyecto.id_proyecto = proyecto_des.id_proyecto
join usuario on proyecto_des.id_desarrollador = usuario.id_usuario
where usuario.correo_electronico = 'SESA1@GMAIL.com';  -- Cambia el correo según el usuario que busques

-- Obtener los desarrolladores con su especialidad y número de proyectos asignados
select usuario.correo_electronico, desarrollador.especialidad, count(proyecto_des.id_proyecto) 
from desarrollador
join usuario on desarrollador.id_usuario = usuario.id_usuario
join proyecto_des on desarrollador.id_usuario = proyecto_des.id_desarrollador
group by usuario.correo_electronico, desarrollador.especialidad;

-- Obtener el número de usuarios de cada tipo
select tipo, count(id_usuario) 
from usuario
group by tipo;

-- Obtener la cantidad de proyectos de cada empresa 
select empresa.nombre, count(proyecto.id_proyecto) 
from empresa
join gerente_proyecto on empresa.id_empresa = gerente_proyecto.id_empresa
join proyecto_des on gerente_proyecto.id_usuario = proyecto_des.id_desarrollador
join proyecto on proyecto_des.id_proyecto = proyecto.id_proyecto
group by empresa.nombre;

-- Obtener los desarrolladores reclutados por cada reclutador
select usuario.correo_electronico, count(reclutamiento.id_desarrollador) 
from reclutador
join usuario on reclutador.id_usuario = usuario.id_usuario
left join reclutamiento on reclutador.id_usuario = reclutamiento.id_reclutador
group by usuario.correo_electronico;





