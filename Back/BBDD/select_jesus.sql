
SELECT usuario.correo_electronico, desarrollador.especialidad
FROM usuario 
JOIN desarrollador  ON usuario.id_usuario = desarrollador .id_usuario;