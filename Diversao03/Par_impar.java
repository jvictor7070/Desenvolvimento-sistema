package Diversao03;
import java.util.Scanner;

public class Par_impar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INforme um número: ");
        int numero = sc.nextInt();

        if(numero %2 == 0){
            System.out.println("Número par");
        }else{
            System.out.println("Número Impar");
        }
        sc.close();
    }
    
}
