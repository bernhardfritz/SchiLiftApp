# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table schilift;

PRAGMA foreign_keys = ON;

