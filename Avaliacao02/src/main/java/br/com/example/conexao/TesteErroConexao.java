package br.com.example.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteErroConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.conectar()) {
            System.out.println("Conexão estabelecida!");
        } catch (SQLException e) {
            System.err.println("Não foi possível concluir a operação no banco de dados.");
            System.err.println("Código do erro SQL: " + e.getErrorCode());
            System.err.println("Detalhes: " + e.getMessage());
        }
    }
}