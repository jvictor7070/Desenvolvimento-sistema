package aula005;
import java.util.Scanner;

public class EX06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe n1:");
        int numero = sc.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(numero+" x"+i+" = "+(numero*i));
        }

        sc.close();
    }
    
}
