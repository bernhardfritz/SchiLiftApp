# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table qrcode_data (
  user_id                   integer,
  start                     timestamp,
  end                       timestamp,
  gemeinde                  varchar(255),
  hash_code                 varchar(255))
;

create table schilift (
  id                        integer primary key AUTOINCREMENT,
  name                      varchar(255),
  plz                       integer,
  gemeinde                  varchar(255),
  baujahr                   integer,
  typ                       varchar(255),
  zubringerfunktion         varchar(255),
  breite                    float,
  personen_pro_aufhaengung  integer,
  sitzplatzheizung          integer(1),
  wetterschutz              integer(1),
  einstiegshilfe            integer(1),
  schraege_laenge           integer,
  hoehe_talstation          integer,
  hoehe_bergstation         integer,
  hoehendifferenz           integer,
  foerderleistung           integer,
  transportkapazitaet       integer)
;

create table user (
  email                     varchar(255) primary key,
  password                  varchar(255))
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table qrcode_data;

drop table schilift;

drop table user;

PRAGMA foreign_keys = ON;

