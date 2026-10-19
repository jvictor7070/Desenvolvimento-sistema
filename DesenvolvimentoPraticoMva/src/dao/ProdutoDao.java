package dao;

import java.util.ArrayList;
import model.Produto;

public class ProdutoDao {
    
    private ArrayList<Produto>produtos = new ArrayList<>();

    public void cadastrar(Produto produto){
        produtos.add(produto);
    }

    public ArrayList<Produto>listar(){
        return produtos;
    }

    public Produto buscar(int id ){
        for(Produto produto:produtos){
            if(produto.getId()==id){
                return produto;
            }
        }
        return null;
    }

    public boolean alterar(int id, String nome,String categoria,double preco,int quantEstoque){
        Produto produto=buscar(id);
        if(produtos != null){
            produto.setId(id);
            produto.setNome(nome);
            produto.setCategoria(categoria);
            produto.setPreco(preco);
            produto.setQuantEstoque(quantEstoque);
            return true;
        }
        return false;
    }

    public boolean remover(int id){
        Produto produto=buscar(id);

        if(produto!=null){
            produtos.remove(produto);
            return true;
        }
        return false;
    }

}
