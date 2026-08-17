package Condicionais;
import java.util.Scanner;

public class Cond05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = sc.nextLine();

        System.out.println("INforme senha: ");
        String senha = sc.nextLine();

        if(nome.equals("Raquel")&& senha.equals("1234")){
            System.out.println("Login realizado com sucesso!!");
        }else{
            System.out.println("Dados incorretos");
        }


        sc.close();
    }
}
