package Diversao03;
import java.util.Scanner;

public class Idade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe sua idade: ");
        int idade = sc.nextInt();

        if(idade<=12){
            System.out.println("CRIANÇA ");
        }else if(idade>12 && idade<18){
            System.out.println("ADOLESCENTE");
        }else if(idade>=18 && idade<60){
            System.out.println("ADULTO ");
        }else{
            System.out.println("IDOSO");
        }

        sc.close();
    }
    
}
