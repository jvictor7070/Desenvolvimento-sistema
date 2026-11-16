package br.com.example.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoTeste {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            if (conn != null) {
                System.out.println("Conexão com o banco empresa_db realizada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao MySQL: " + e.getMessage());
        }
    }
}