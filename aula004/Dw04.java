package aula004;
import java.util.Scanner;

public class Dw04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha = "";

        do{
            System.out.println(senha);
            System.out.println("Informe a senha: ");
            senha = sc.nextLine();
            System.out.println("Acesso permitido! ");
        }while(!senha.equals("1234"));
        

        sc.close();
        
    }
    
}
