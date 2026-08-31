
import java.util.Scanner;

public class Classificador_Numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int numero = sc.nextInt();

        if(numero>0){
        System.out.println("O número é Positivo");
        }else if(numero<0){
        System.out.println("O número é Negativo");
    }else{
        System.out.println("O número é Zero");
        }
        sc.close();
    }
    
}
