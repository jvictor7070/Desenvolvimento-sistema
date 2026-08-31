import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro: ");
        int numero = sc.nextInt();
        

        for(int i = 1;i<=10;i++){
            int resultado = numero*i;
            System.out.println(""+numero+"X"+i+"="+resultado);
        
        }
        
        
        sc.close();
    }
    
}
