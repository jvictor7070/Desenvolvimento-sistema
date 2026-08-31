
import java.util.Scanner;

public class DescontoCinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe sua idade: ");
        int idade = sc.nextInt();

        System.out.println("Você é estudante (true/false): ");
        boolean estudante = sc.nextBoolean();

        if(idade < 18 || estudante ){
            System.out.println("Paga Meia-Entrada");
        }else{
            System.out.println("Paga Entrada Inteira");
        }



        sc.close();
    }
    
}
