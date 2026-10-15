package requisitos;

public class Produto {
    
    private int codigo;
    private String nome;
    private double telefone;

    public Produto(int codigo, String nome, double telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double gettelefone() {
        return telefone;
    }

    public void settelefone(double telefone) {
        this.telefone = telefone;
    }

   
    }
    

