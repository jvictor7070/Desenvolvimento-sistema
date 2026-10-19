package model;

public class Produto{
    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int quantEstoque;


    public Produto(int id, String nome,String categoria,double preco,int quantEstoque){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantEstoque = quantEstoque;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
    
    
}
