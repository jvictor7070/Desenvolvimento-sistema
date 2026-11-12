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

    private Connection getConexao() throws SQLException {
        return new Conexao().conectar();
    }

    public boolean cadastrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios(matricula, nome, idade, tipo, departamento, funcao) VALUES(?,?,?,?,?,?)";
        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            String tipo = "FUNC";
            String departamento = "null";
            String funcao = "null";

            if (funcionario instanceof Gerente) {
                tipo = "GER"; // Padronizado em maiúsculo para bater com listar() e buscar()
                departamento = ((Gerente) funcionario).getDepartamento();
            } else if (funcionario instanceof Operador) {
                tipo = "OPR";
                funcao = ((Operador) funcionario).getFuncao();
            }

            comando.setInt(1, funcionario.getMatricula());
            comando.setString(2, funcionario.getNome());
            comando.setInt(3, funcionario.getIdade());
            comando.setString(4, tipo);
            comando.setString(5, departamento);
            comando.setString(6, funcao);

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT matricula, nome, idade, tipo, departamento, funcao FROM funcionarios ORDER BY matricula";

        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Funcionario func;
                String tipo = resultado.getString("tipo");
                if ("GER".equals(tipo)) {
                    func = new Gerente(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("departamento"));
                } else if ("OPR".equals(tipo)) {
                    func = new Operador(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("funcao"));
                } else {
                    func = new Funcionario();
                    func.setMatricula(resultado.getInt("matricula"));
                    func.setNome(resultado.getString("nome"));
                    func.setIdade(resultado.getInt("idade"));
                }
                funcionarios.add(func);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return funcionarios;
    }

    public Funcionario buscar(int matricula) {
        String sql = "SELECT matricula, nome, idade, tipo, departamento, funcao FROM funcionarios WHERE matricula=?";
        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, matricula);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    String tipo = resultado.getString("tipo");
                    if ("GER".equals(tipo)) {
                        return new Gerente(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("departamento"));
                    } else if ("OPR".equals(tipo)) {
                        return new Operador(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("funcao"));
                    } else {
                        Funcionario func = new Funcionario();
                        func.setMatricula(resultado.getInt("matricula"));
                        func.setNome(resultado.getString("nome"));
                        func.setIdade(resultado.getInt("idade"));
                        return func;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return null;
    }

    // Método corrigido recebendo o objeto Funcionario que o Controller envia
    public boolean alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome=?, idade=?, tipo=?, departamento=?, funcao=? WHERE matricula=?";
        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            String tipo = "FUNC";
            String departamento = "null";
            String funcao = "null";

            if (funcionario instanceof Gerente) {
                tipo = "GER";
                departamento = ((Gerente) funcionario).getDepartamento();
            } else if (funcionario instanceof Operador) {
                tipo = "OPR";
                funcao = ((Operador) funcionario).getFuncao();
            }

            comando.setString(1, funcionario.getNome());
            comando.setInt(2, funcionario.getIdade());
            comando.setString(3, tipo);
            comando.setString(4, departamento);
            comando.setString(5, funcao);
            comando.setInt(6, funcionario.getMatricula()); // Parâmetro do WHERE

            return comando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(int matricula) {
        String sql = "DELETE FROM funcionarios WHERE matricula=?";
        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, matricula);
            return comando.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            return false;
        }
    }
}