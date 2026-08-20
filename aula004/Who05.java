package aula004;
import java.util.Scanner;
public class Who05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op=0;

        while(op!=5){
            System.out.println("=====MENU=====");
            System.out.println("1-Cadastro");
            System.out.println("2-Listar");
            System.out.println("3-Alterar");
            System.out.println("4-Remover");
            System.out.println("5-Sair");
            System.out.println("Escolha a opção: ");
            op=sc.nextInt();
        }
        sc.close();

        switch (op) {
            case 1:
                System.out.println("Cadastrar");
                break;
            case 2:
                System.out.println("Listar");
                 break;
            case 3:
                System.out.println("Alterar");
                 break;
            case 4:
                System.out.println("Remover");
                 break;
            case 5:
                System.out.println("Sair");
                
                
                break;
        
            default:
                break;
        }
        }
    
}
