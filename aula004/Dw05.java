package aula004;
import java.util.Scanner;

public class Dw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        do{
            System.out.println("1-Iniciar o jogo");
            System.out.println("2-Carregar o jogo");
            System.out.println("3-Configuração");
            System.out.println("0-Sair");
            System.out.println("Escolha uma opção: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Iniciar o jogo");
                case 2:
                    System.out.println("Carregar o jogo");
                case 3:
                    System.out.println("Configurações do jogo");
                case 0:
                    System.out.println("Sair do jogo");

                    break;
            
                default:
                    break;
            }
        }
    }
    
}
