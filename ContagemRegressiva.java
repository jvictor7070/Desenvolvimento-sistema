
import java.util.Scanner;

public class ContagemRegressiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro: ");
        int numero = sc.nextInt();
        
        for(int i=numero ; i>=0 ;i--){
        System.out.println("Número: "+i);
    }

    System.out.println("Lançamento realizado!");
        
        sc.close();
    }
    
}
