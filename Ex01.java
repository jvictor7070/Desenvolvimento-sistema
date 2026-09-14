import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();

        // Adicionar
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Marcos");

        // Listar
        System.out.println("Lista");
        for (String nome: nomes){
        System.out.println(nome);
    }

        // Alterar

        nomes.set(1,"edivan");

        System.out.println("Lista após alterar");
        for (String nome:nomes){
            System.out.println(nome);
        }
        // Remove

        nomes.remove(0);

        System.out.println("Lista após remove");
        for (String nome:nomes){
            System.out.println(nome);
        }
    }
}
