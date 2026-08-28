package outros;
import java.util.Scanner;

public class TabuadaContagem {
   public TabuadaContagem() {
   }

   public static void main(String[] var0) {
      Scanner var2 = new Scanner(System.in);

      int var1;
      do {
         System.out.println("1- Calcular tabuada");
         System.out.println("2- Contagem regressiva");
         System.out.println("3- Sair");
         System.out.println("Escolha uma opção: ");
         var1 = var2.nextInt();
         switch (var1) {
            case 1 -> {
                System.out.println("Informe o número: ");
                int var5 = var2.nextInt();
                System.out.println("===Tabuada===");
                
                for(int var4 = 1; var4 <= 10; ++var4) {
                    System.out.println(var5 + " x " + var4 + " = " + var5 * var4);
                }
              }
            case 2 -> {
                for(int var3 = 10; var3 >= 1; --var3) {
                    System.out.println("Número:" + var3);
                }
              }
         }

         var2.close();
      } while(var1 != 3);

   }
}
