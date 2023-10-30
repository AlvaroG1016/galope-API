create table pedidos(
                        id bigint not null auto_increment,
                        id_mesero BIGINT NOT NULL,
                        id_mesa BIGINT NOT NULL,
                        descripcion varchar(100) not null,
                        fecha date not null,
                        observaciones varchar(100) ,


                        primary key (id),
                        FOREIGN KEY (id_mesero) REFERENCES meseros(id_mesero),
                        FOREIGN KEY (id_mesa) REFERENCES mesas(id_mesa)

);