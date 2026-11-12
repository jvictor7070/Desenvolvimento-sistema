CREATE DATABASE IF NOT EXISTS empresa_db;
USE empresa_db;

CREATE TABLE IF NOT EXISTS funcionarios(
	matricula INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    departamento VARCHAR(50) NOT NULL,
    funcao VARCHAR(50) NOT NULL
);
select * FROM funcionarios