import java.util.Scanner; 

public class calculadora1 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe n1:");
        double n1 = sc.nextDouble();
        
        System.out.println("Informe n2:");
        double n2 = sc.nextDouble();

        double sub=n1-n2;
        double mult=(n1*n2);
        double div=(n1/n2);
        double soma=(n1+n2);

        System.out.println(soma);
        System.out.println(sub);
        System.out.println(mult);
        System.out.println(div);

        sc.close();
}
}