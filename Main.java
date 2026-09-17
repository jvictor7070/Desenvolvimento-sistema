
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do cliente: ");
        String nome = sc.nextLine();

        Cliente cliente = new Cliente(nome);
        cliente.mostrarDados(nome);

        System.out.println("Informe o nome do produto: ");
        String produto=sc.nextLine();

        System.out.println("Informe a quantidade do produto: ");
        int quantidade=sc.nextInt();

        System.out.println("Informe a valor do produto: ");
        double valor=sc.nextDouble();
        System.out.println("");

        cliente.comprar(produto,quantidade);

        System.out.println("");

        cliente.comprar(produto, quantidade, valor);

        double total = quantidade*valor;

        System.out.println("=======Pagamento=======");
        cliente.pagar(total);
        sc.close();
    }
    
}
