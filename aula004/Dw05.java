package aula004;
import java.util.Scanner;

public class Dw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op; // Declarada fora do bloco 'do' para ser visível na condição do 'while'

        do {
            System.out.println("1-Iniciar o jogo");
            System.out.println("2-Carregar o jogo");
            System.out.println("3-Configuração");
            System.out.println("0-Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Iniciar o jogo");
                    break;
                case 2:
                    System.out.println("Carregar o jogo");
                    break;
                case 3:
                    System.out.println("Configurações do jogo");
                    break;
                case 0:
                    System.out.println("Sair do jogo");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0); // Faltava o fechamento da estrutura do-while

        sc.close();
    }
}