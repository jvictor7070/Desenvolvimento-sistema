
import java.util.ArrayList;
import java.util.Scanner;


public class Ex02 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(20);
        numeros.add(30);
        numeros.add(40);

        System.out.println("Números cadastrados");
        for (Integer numero : numeros){
        System.out.println(numero);}

        System.out.println("\ndigite o número que deseja remover");
        int numeroRemover = sc.nextInt();

        numeros.remove(Integer.valueOf(numeroRemover));
        System.out.println("Após remover");

        for (Integer numero : numeros){
            System.out.println(numero);}

            sc.close();
    }

    
}
