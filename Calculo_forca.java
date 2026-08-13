import java.util.Scanner;

public class Calculo_forca {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe a força aplicada: ");
    double forca = sc.nextDouble();
    
    System.out.println("Informe a distancia: ");
    double distancia = sc.nextDouble();
    

    Double trabalho = (forca*distancia);

    System.out.println("O trabalho exercido é de:"+trabalho);

    sc.close();
    
}
}
