package Diversao03;
import java.util.Scanner;

public class Tabela_cores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------- TABELA DE PREÇOS DE CDs -------");
        System.out.println("Cores disponíveis: Verde | Azul | Amarelo | Vermelho\n");

        System.out.println("Informe uma cor:");
        String cor = sc.nextLine();


        if(cor.equals("verde")){
            System.out.println("\nO preço do CD com a etiqueta VERDE é: R$ 10,00");
        }else if(cor.equals("azul")){
            System.out.println("\nO preço do CD com a etiqueta AZUL é: R$ 20,00");
        }else if(cor.equals("amarelo")){
            System.out.println("\nO preço do CD com a etiqueta AMARELO é: R$ 30,00");
        }else if(cor.equals("vermelho")){
            System.out.println("\nO preço do CD com a etiqueta VERMELHO é: R$ 40,00");
        }else{
            System.out.println("Cor inválida");
        }


        sc.close();
    }
    
}
