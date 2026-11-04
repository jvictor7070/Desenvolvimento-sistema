package com.example;

import java.util.List;

/**
 * Camada de Controle - Intermedia as solicitações da Interface e as operações do DAO.
 */
public class EletrodomesticoControle {

    private final EletrodomesticoDAO dao = new EletrodomesticoDAO();

    public boolean cadastrarEletrodomestico(String nome, String marca, String voltagem, double preco) {
        Eletrodomestico e = new Eletrodomestico(nome, marca, voltagem, preco);
        return dao.cadastrar(e);
    }

    public List<Eletrodomestico> listarEletrodomesticos() {
        return dao.listar();
    }

    public Eletrodomestico buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    public boolean alterarEletrodomestico(int id, String nome, String marca, String voltagem, double preco) {
        Eletrodomestico e = new Eletrodomestico(id, nome, marca, voltagem, preco);
        return dao.atualizar(e);
    }

    public boolean removerEletrodomestico(int id) {
        return dao.remover(id);
    }
}