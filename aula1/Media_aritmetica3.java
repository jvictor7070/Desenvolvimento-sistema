package aula1;
import java.util.Scanner;

public class Media_aritmetica3 {

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe n1:");
        double n1 = sc.nextDouble();
        
        System.out.println("Informe n2:");
        double n2 = sc.nextDouble();
        
        System.out.println("Informe n3:");
        double n3 = sc.nextDouble();

        double media=(n1+n2+n3)/3;

       
        System.out.println(media);

        sc.close();
}
}
    

