create table cursos (
    id bigint not null auto_increment primary key,
    nombre varchar(100) not null,
    categoria varchar(100) not null
);

create table temas (
    id bigint not null auto_increment primary key,
    titulo varchar(100) not null unique,
    mensaje varchar(250) not null unique,
    fecha_creacion datetime not null,
    estado tinyint not null default 0,
    respuesta bigint not null default 0,
    usuario_id bigint not null,
    curso_id bigint not null,

    constraint fk_temas_cursos_id foreign key(curso_id) references cursos(id),
    constraint fk_temas_usuarios_id foreign key(usuario_id) references usuarios(id)
);

create table respuestas (
    id bigint not null auto_increment primary key,
    mensaje varchar(250) not null,
    fecha_creacion datetime not null,
    solucion tinyint not null default 0,
    tema_id bigint not null,
    usuario_id bigint not null,

    constraint fk_respuestas_temas_id foreign key(tema_id) references temas(id),
    constraint fk_respuestas_usuarios_id foreign key(usuario_id) references usuarios(id)
);
