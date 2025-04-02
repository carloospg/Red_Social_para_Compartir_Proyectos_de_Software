

INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('DESARROLLADOR','USUARIOSESA1@GMAIL.com',784589256,'1446','17/05/2019');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('RECLUTADOR','USUARIORECLU1@GMAIL.com',68957435,'1426','07/02/2001');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('DESARROLLADOR','USUARIOSESA2@GMAIL.com',186579148,'1451','16/05/2005');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('RECLUTADOR','USUARIORECLU2@GMAIL.com',159867436,'1156','07/08/2009');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('GERENTES','USUARIOGERENTE1@GMAIL.com',169874568,'2256','10/05/2009');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('DESARROLLADOR','USUARIOSESA3@GMAIL.com',158769486,'1656','17/05/2020');
INSERT INTO USUARIO (tipo,correo_electronico,telefono,contrasenia,fecha_alta) VALUES ('GERENTES','USUARIOSGERENTE2@GMAIL.com',147859684,'14666','27/08/2017');


INSERT INTO empresa (id_empresa,cif, nombre) VALUES(1452,'B1234567', 'Indra');
INSERT INTO empresa (id_empresa,cif, nombre) VALUES(7878,'C9876543', 'Tecno suport');
INSERT INTO empresa (id_empresa,cif, nombre) VALUES(6968,'A8596854','master software');



INSERT INTO proyecto (nombre, descripcion) VALUES ('Sistema de Gesti�n', 'Aplicaci�n para gestionar proyectos');
INSERT INTO proyecto (nombre, descripcion) VALUES ('reclutamiento', 'Sistema para reclutar desarrolladores');


INSERT INTO desarrollador (id_usuario, especialidad, github) VALUES (3, 'Desarrollador Backend', 'https://github.com/dev1');
INSERT INTO desarrollador (id_usuario, especialidad, github) VALUES (2, 'Frontend Developer', 'https://github.com/dev2');


INSERT INTO proyecto_des (id_proyecto, id_desarrollador) VALUES(1, 2);
INSERT INTO proyecto_des (id_proyecto, id_desarrollador) VALUES(1, 3);




INSERT INTO reclutador (id_usuario, id_empresa) VALUES(2, 1452);
INSERT INTO reclutador (id_usuario, id_empresa) VALUES(4, 7878);



INSERT INTO gerente_proyecto (id_usuario, id_empresa) VALUES (3,7878);
INSERT INTO gerente_proyecto (id_usuario, id_empresa) VALUES (5,1452);



INSERT INTO comentario (id_comentario, id_usuario) VALUES (2,3);
INSERT INTO comentario (id_comentario, id_usuario) VALUES (3,2);



INSERT INTO coment_proyecto (id_comentario, id_proyecto) VALUES(2, 1);
INSERT INTO coment_proyecto (id_comentario, id_proyecto) VALUES(3, 2);