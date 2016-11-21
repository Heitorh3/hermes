
create table cliente (
        codigo bigint not null auto_increment,
        celular varchar(255) not null,
        cpf varchar(255) not null,
        email varchar(255),
        nome varchar(255) not null,
        telefone varchar(255) not null,
        primary key (codigo)
    );
