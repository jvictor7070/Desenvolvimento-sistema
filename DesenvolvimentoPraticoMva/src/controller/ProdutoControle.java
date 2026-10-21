package controller;

import dao.ProdutoDao;
import java.util.ArrayList;
import model.Produto;

public class ProdutoControle {

    private ProdutoDao dao;

    public ProdutoControle(){
        dao = new ProdutoDao();
    }

    public void cadastrar(int id, String nome,String categoria,double preco,int quantEstoque){

        Produto produto = new Produto(id,nome,categoria,preco,quantEstoque);
        dao.cadastrar(produto);
    }

    public ArrayList<Produto>listar(){
        return dao.listar();
    }

    public Produto buscar(int id){
        return dao.buscar(id);
    }

    public boolean  alterar(int id, String nome,String categoria,double preco,int quantEstoque){
        return dao.alterar(id, nome, categoria, preco, quantEstoque);
    }


    public boolean remover(int id){
        return dao.remover(id);
    }
}
