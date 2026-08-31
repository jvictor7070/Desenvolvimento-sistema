import java.util.Scanner;

public class SomadorContinuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = 0;

        while(numero!=0){
            System.out.println("Digite um número (ou 0 para encerrar): ");
            numero = sc.nextInt();

            if(numero != 0){
                System.out.println("Você digitou: " + numero);
            }else{
                break;
                numero =
            }
        }

        

        sc.close();
    }
    
}
