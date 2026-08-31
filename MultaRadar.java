
import java.util.Scanner;

public class MultaRadar {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Informe a velocidade do veiculo: ");
        double velocidade = sc.nextDouble();

        if(velocidade <=80){
        System.out.println("Velocidade permitida");
        }else if(velocidade<=100){
        System.out.println("Multa Leve: R$ 130,16");
        }else{
        System.out.println("Multa Grave: R$ 293,47");
        }
        sc.close();
    }
    
}
