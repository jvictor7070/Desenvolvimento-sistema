package Diversao03;
import java.util.Scanner;

public class Positivo_negativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro: ");
        int numero = sc.nextInt();

        if(numero<0){
            System.out.println("Número Negativo");
        }else if(numero>0){
            System.out.println("Número Positivo");
        }else{
            System.out.println("Número nulo");
        }

        sc.close();
    }
    
}
