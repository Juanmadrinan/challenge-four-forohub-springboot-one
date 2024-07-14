CREATE TABLE usuarios (
    id integer NOT NULL UNIQUE AUTO_INCREMENT,
    user varchar(255) NOT NULL,
    password varchar(300) NOT NULL
);