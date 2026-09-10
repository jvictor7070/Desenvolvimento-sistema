package poo;
import java.util.Scanner;

public class LojaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Loja c = new Loja(null,0.0,0);

        System.out.println("Informe o nome do produto: ");
        c.setNome(sc.nextLine());
        System.out.println("Informe o preço do produto: ");
        c.setPreco(sc.nextDouble());
        System.out.println("Informe a quantidade de produtos: ");
        c.setQuantidade(sc.nextInt());

        System.out.println("O Nome: "+c.getNome());
        System.out.println("O Preço: "+c.getPreco());
        System.out.println("A Quantidade: "+c.getQuantidade());

        sc.close();
    }
}
