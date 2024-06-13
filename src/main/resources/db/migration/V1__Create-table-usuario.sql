create table usuarios (
    id bigint not null auto_increment primary key,
    nombre varchar(100) not null,
    email varchar(100) not null,
    password varchar(300) not null
);

create table perfiles (
    id bigint not null auto_increment primary key,
    nombre varchar(100) not null
);

create table user_profile (
    usuario_id bigint not null,
    perfil_id bigint not null,

    constraint fk_usuario_id foreign key (usuario_id) references usuarios (id),
    constraint fk_perfil_id foreign key (perfil_id) references perfiles (id)
);