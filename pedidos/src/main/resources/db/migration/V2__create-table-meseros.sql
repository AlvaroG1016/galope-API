create table meseros(
                        id_mesero bigint not null auto_increment,
                        nombre varchar(100) not null,
                        documento varchar(6) not null unique ,


                        primary key (id_mesero)
);
