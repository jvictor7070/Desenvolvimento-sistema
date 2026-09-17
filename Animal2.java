public abstract class Animal2 {

    private String nome;

    private int idade;

    public Animal(){
    }

    public Animal(String nome, int idade){
        this.nome = nome;
        this.idade=idade;
    }
    
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }
    
}
