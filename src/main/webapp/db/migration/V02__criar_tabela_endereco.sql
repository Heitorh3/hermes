 create table endereco (
        codigo bigint not null auto_increment,
        bairro varchar(255) not null,
        cep varchar(255),
        cidade varchar(255),
        estado varchar(255),
        numero varchar(255) not null,
        rua varchar(255) not null,
        codigo_cliente bigint,
        primary key (codigo)
    )engine=InnoDB;