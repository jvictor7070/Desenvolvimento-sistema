package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por fornecer a conexão com o banco de dados MySQL.
 */
public class ConexoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USUARIO = "root";
    private static final String SENHA = "sua_senha_aqui";

    /**
     * Estabelece e retorna uma conexão ativa com o banco de dados.
     *
     * @return objeto Connection do JDBC
     * @throws SQLException em caso de falha de conexão
     */
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}