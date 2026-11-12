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
             PreparedStatement comando = conexao.prepareStatement(sql)){

                String tipo = "FUNC";
                String departamento = "null";
                String funcao = "null";

                if(funcionario instanceof  Gerente){
                    tipo = "Ger";
                    departamento = ((Gerente) funcionario).getDepartamento();
                }else if (funcionario instanceof Operador) {
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
        String sql = "SELECT matricula, nome, idade,tipo, departamento,funcao FROM funcionarios ORDER BY matricula";

        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Funcionario func;
                String tipo = resultado.getString("tipo");
                if (tipo.equals("GER")) {
                    Gerente gerente = new Gerente(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("departamento"));
                    func = gerente;
                } else if (tipo.equals("OPR")) {
                    Operador operador = new Operador(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("funcao"));
                    func = operador;
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
                    if (tipo.equals("GER")) {

                        Gerente gerente = new Gerente(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("departamento"));
                        return gerente;
                    } else if (tipo.equals("OPR")) {

                        Operador operador = new Operador(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("funcao"));
                        return operador;
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

    public boolean alterar(int matricula, String nome, int idade, String tipo,String departamento,String funcao) {
        String sql = "UPDATE funcionarios SET matricula=?, nome=?, idade=?, tipo=?, departamento=?, funcao=? WHERE matricula=?";
        try (Connection conexao = getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, matricula);
                comando.setString(2, nome);
                comando.setInt(3, idade);
                comando.setString(4, tipo);
                comando.setString(5, departamento);
                comando.setString(6, funcao);
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

    public boolean alterar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}