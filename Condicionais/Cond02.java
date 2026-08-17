package Condicionais;
import java.util.Scanner;

public class Cond02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar a frequência do aluno: ");
        double frequencia = sc.nextDouble();

        System.out.println("Informar nota do aluno: ");
        double nota = sc.nextDouble();

        if (nota>=7 && frequencia>=75){
            System.out.println("Aprovado");
        }else{
            System.out.println("Reprovado");
        }

        sc.close();

    }
    
}
