CREATE TABLE topicos (
    id integer NOT NULL UNIQUE AUTO_INCREMENT,
    titulo varchar(255) NOT NULL,
    mensaje varchar(255) NOT NULL,
    fecha_creacion date NOT NULL,
    status boolean NOT NULL,
    autor varchar(255) NOT NULL,
    curso varchar(255) NOT NULL
);