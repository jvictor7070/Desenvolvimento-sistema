package poo;
import java.util.Scanner;

public class CarroApp {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Carro c = new Carro(null,null,0);

        System.out.println("Informe a marca: ");
        c.setMarca(sc.nextLine());

        System.out.println("Informe o modelo: ");
        c.setModelo(sc.nextLine());

        System.out.println("Informe o ano: ");
        c.setAnoFabricacao(sc.nextInt());

        System.out.println("A Marca: "+c.getMarca());
        System.out.println("O Modelo: "+c.getModelo());
        System.out.println("O ano de fabricação: "+c.getAnoFabricacao());
        sc.close();

    }
    
}
