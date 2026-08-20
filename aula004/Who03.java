package aula004;
import java.util.Scanner;
public class Who03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número:");
        int limite = sc.nextInt();

        int numero=1;
        while(numero<=limite){
            System.out.println(numero);
            numero++;
        }

        sc.close();
        
    }
    
}
