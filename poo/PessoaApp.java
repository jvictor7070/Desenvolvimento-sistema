package poo;
public class PessoaApp {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1,"jubilcleidison");
        Pessoa p2 = new Pessoa(2,"paola");

        // Acessador
        System.out.println("Pessoa: "+p1.getCodigo()+"nome: "+p1.getNome());
        
        // Modificador
        p1.setNome("gaylherme");
        
        System.out.println("Pessoa: "+p1.getCodigo()+"nome: "+p1.getNome());

    }
    
}
