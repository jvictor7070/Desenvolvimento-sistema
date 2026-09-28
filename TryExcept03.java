import java.util.InputMismatchException;
import java.util.Scanner;
public class TryExcept03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Informe um número inteiro: ");
            int numero=sc.nextInt();
            System.out.println("Você digitou: "+numero);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Você deve digitar um número inteiro");
        }
        sc.close();
    }
    
}
