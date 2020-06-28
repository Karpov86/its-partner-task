create table lamps
(
    id             bigint not null auto_increment,
    lamp_condition varchar(255),
    primary key (id)
) engine = InnoDB;

create table rooms
(
    id        bigint not null auto_increment,
    country   varchar(255),
    room_name varchar(255),
    lamp_id   bigint,
    primary key (id)
) engine = InnoDB;

alter table rooms
    add constraint FKbb2martgeubgst7e4h7145t6p foreign key (lamp_id) references lamps (id);