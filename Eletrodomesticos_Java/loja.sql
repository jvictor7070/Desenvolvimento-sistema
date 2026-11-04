-- Script de inicialização do banco de dados MySQL
-- Crie o banco 'loja' e a tabela 'eletrodomestico'

DROP DATABASE IF EXISTS loja;
CREATE DATABASE loja CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE loja;

CREATE TABLE eletrodomestico (
    id       INT PRIMARY KEY AUTO_INCREMENT,
    nome     VARCHAR(100) NOT NULL,
    marca    VARCHAR(100) NOT NULL,
    voltagem VARCHAR(20)  NOT NULL,
    preco    DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB;

-- Exemplo de dados iniciais (opcional)
INSERT INTO eletrodomestico (nome, marca, voltagem, preco) VALUES
('Geladeira',     'Brastemp', '220V', 1599.90),
('Mikrowave',     'Panasonic', '220V', 499.90),
('Lavadora',      'Samsung',  '220V', 1899.00);