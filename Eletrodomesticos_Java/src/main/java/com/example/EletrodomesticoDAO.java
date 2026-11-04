package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Camada de acesso a dados (DAO) - todas as instruções SQL estão aqui.
 */
public class EletrodomesticoDAO {

    private final ConexoMySQL cone = new ConexoMySQL();

    /**
     * Insere um novo eletrodoméstico no banco.
     */
    public boolean cadastrar(Eletrodomestico e) {
        String sql = "INSERT INTO eletrodomestico (nome, marca, voltagem, preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = cone.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNome());
            ps.setString(2, e.getMarca());
            ps.setString(3, e.getVoltagem());
            ps.setDouble(4, e.getPreco());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Falha ao cadastrar: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Lista todos os eletrodomésticos.
     */
    public List<Eletrodomestico> listar() {
        List<Eletrodomestico> lista = new ArrayList<>();
        String sql = "SELECT id, nome, marca, voltagem, preco FROM eletrodomestico ORDER BY id";
        try (Connection conn = cone.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Eletrodomestico e = new Eletrodomestico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("voltagem"),
                        rs.getDouble("preco")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Falha ao listar: " + ex.getMessage());
        }
        return lista;
    }

    /**
     * Busca um eletrodoméstico pelo ID.
     */
    public Eletrodomestico buscarPorId(int id) {
        String sql = "SELECT id, nome, marca, voltagem, preco FROM eletrodomestico WHERE id = ?";
        try (Connection conn = cone.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Eletrodomestico(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("marca"),
                            rs.getString("voltagem"),
                            rs.getDouble("preco")
                    );
                }
            }
        } catch (SQLException ex) {
            System.err.println("Falha ao buscar: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Atualiza os dados de um eletrodoméstico.
     */
    public boolean atualizar(Eletrodomestico e) {
        String sql = "UPDATE eletrodomestico SET nome = ?, marca = ?, voltagem = ?, preco = ? WHERE id = ?";
        try (Connection conn = cone.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNome());
            ps.setString(2, e.getMarca());
            ps.setString(3, e.getVoltagem());
            ps.setDouble(4, e.getPreco());
            ps.setInt(5, e.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Falha ao atualizar: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Remove um eletrodoméstico pelo ID.
     */
    public boolean remover(int id) {
        String sql = "DELETE FROM eletrodomestico WHERE id = ?";
        try (Connection conn = cone.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Falha ao remover: " + ex.getMessage());
            return false;
        }
    }
}