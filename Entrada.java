import java.util.Scanner; 

public class Entrada {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Informe N1: ");
        double N1 = sc.nextDouble();

        System.out.println("Informe N2: ");
        double N2 = sc.nextDouble();

        double media=(N1+N2)/2;

        System.out.println("olá "+nome+ ", sua média é: "+media);

        sc.close();
    }


    
}
