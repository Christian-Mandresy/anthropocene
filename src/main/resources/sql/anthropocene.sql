create table Information(
    id smallint primary key not null AUTO_INCREMENT,
    titre varchar(200),
    auteur varchar(50),
    image varchar(70),
    datepublication date
);

create table DetailInfo(
    id smallint primary key not null auto_increment,
    idInfo smallint,
    Description TEXT,
    image varchar(70),
    FOREIGN KEY (idInfo) REFERENCES Information(id)
);

create table User(
    id smallint primary key not null auto_increment,
    nom VARCHAR(100),
    utilisateur VARCHAR(60),
    mdp VARCHAR(125)
);