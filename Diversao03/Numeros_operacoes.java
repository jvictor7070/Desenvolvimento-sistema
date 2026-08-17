package Diversao03;
import java.util.Scanner;

public class Numeros_operacoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o n1:");
        double n1 = sc.nextDouble();
        
        System.out.println("Informe o n2:");
        double n2 = sc.nextDouble();

        double operacao = (n1+n2);

        System.out.printf("N1:"+n1+ "+N2:"+n2+ "="+operacao);

        sc.close();
    }
    
}
