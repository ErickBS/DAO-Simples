Este projeto é um teste simples de implementação de um JDBC + DAO, usando uma tabela simples. Está compactado, além do projeto, um driver para o DriverManager se conectar com o MYSQL. Segue o query necessário para preparar a tabela para funcionar com o código.

DROP DATABASE IF EXISTS `empresa`;
CREATE DATABASE `empresa`;
USE `empresa`;

CREATE TABLE contato (
  id INT NOT NULL,
  nome VARCHAR(50),
  telefone VARCHAR(50),
  idade INT,
  genero VARCHAR(1),
  data_de_nasc DATE,
  PRIMARY KEY (id)
);

INSERT INTO contato (id, nome, telefone, idade, genero, data_de_nasc)
VALUES
(1, 'Leslie', '41984069885', 44, 'F','1979-09-25'),
(2, 'Tom', '41988959345', 36, 'M', '1987-03-04')