package outros;
import java.util.Scanner;

public class Tabuada02 {
   public Tabuada02() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Informe n1:");
      int var2 = var1.nextInt();

      for(int var3 = 1; var3 <= 10; ++var3) {
         System.out.println(var2 + " x" + var3 + " = " + var2 * var3);
         var1.close();
      }

   }
}
