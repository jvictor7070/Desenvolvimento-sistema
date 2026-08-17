package Condicionais;
import java.util.Scanner;

public class Cond04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar a idade: ");
        int idade = sc.nextInt();

        if(idade<=12){
            System.out.println("Criança");
        }else if(idade>=13 && idade<=17){
            System.out.println("Adolescente");
        }else if(idade>=18 && idade <= 64 ){
            System.out.println("Adulto");
        }else{
            System.out.println("Idoso");
        }


        sc.close();
    }
    
}
