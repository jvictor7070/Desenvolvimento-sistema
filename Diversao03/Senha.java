package Diversao03;
import java.util.Scanner;

public class Senha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe sua senha: ");    
        String senha = sc.nextLine();
        
        if(senha.equals("senha123")){
            System.out.println("Porta Aberta");
        }else{
            System.out.println("Senha não confere");
        }
            
            sc.close();
            
        }
}
