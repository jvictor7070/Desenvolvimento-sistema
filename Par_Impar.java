public class Par_Impar {
   public Par_Impar() {
   }

   public static void main(String[] var0) {
      for(int var1 = 52; var1 <= 100; ++var1) {
         if (var1 % 2 == 0) {
            System.out.println("números pares: " + var1);
         }
      }

      for(int var2 = 1; var2 <= 51; ++var2) {
         if (var2 % 2 != 0) {
            System.out.println("números impares: " + var2);
         }
      }

   }
}
