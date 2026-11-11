package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.example.conexao.Conexao;
import br.com.example.model.Funcionario;
import br.com.example.model.Gerente;
import br.com.example.model.Operador;

public class FuncionarioDao {

    public boolean cadastrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios(matricula, nome, idade, tipo) VALUES(?,?,?,?)";

        try (Connection conexao = conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, funcionario.getMatricula());
            comando.setString(2, funcionario.getNome());
            comando.setInt(3, funcionario.getIdade());
            // Define o tipo baseando na classe real do objeto
            String tipo = "FUNC";
            if (funcionario instanceof Gerente) {
                tipo = "GER";
            } else if (funcionario instanceof Operador) {
                tipo = "OPR";
            }
            comando.setString(4, tipo);
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Funcionario> listar(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT matricula,nome,idade,tipo FROM funcionarios ORDER BY matricula";

        try(C0nnection conexao = Conexao.conectar();
    PreparedStatement comando=conexao.prepareStatement(sql);)
    }

    
}