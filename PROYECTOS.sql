create table usuario(
    id_usuario number(6)generated always as identity primary key,
    tipo varchar2(15) not null,
    correo_electronico varchar2(30) unique,
    telefono number (9),
    contrasenia varchar2(12) not null,
    fecha_alta date
);

create table proyecto(
    id_proyecto number(6) generated always as identity primary key,
    nombre varchar2(20),
    descripcion varchar2(100)
    
);

create table desarrollador (
    id_usuario number(6) primary key,
    especialidad varchar2(50),
    github varchar2(255),
    foreign key (id_usuario) references usuario(id_usuario)
);


create table proyecto_des(
    id_proyecto number(6),
    id_desarrollador number(6),
    foreign key(id_proyecto) references proyecto(id_proyecto),
    foreign key (id_desarrollador) references desarrollador(id_usuario),
    primary key (id_proyecto, id_desarrollador)
);

create table empresa(
    id_empresa number(5) primary key,
    cif varchar2(9) unique,
    nombre varchar2(25)
);

create table reclutador (
    id_usuario number(6) primary key,
    id_empresa number(5),
    foreign key(id_usuario) references usuario(id_usuario),
    foreign key (id_empresa) references empresa(id_empresa)
);

create table gerente_proyecto (
    id_usuario number(6) primary key,
    id_empresa number(5),
    foreign key (id_usuario) references usuario(id_usuario),
    foreign key (id_empresa) references empresa(id_empresa)
);

create table comentario(
    id_comentario number(10) primary key,
    id_usuario number(6),
    foreign key (id_usuario) references usuario(id_usuario)
);

create table coment_proyecto(
    id_comentario number(10) primary key,
    id_proyecto number(6),
    foreign key (id_comentario) references comentario(id_comentario),
    foreign key (id_proyecto) references proyecto(id_proyecto)
);

