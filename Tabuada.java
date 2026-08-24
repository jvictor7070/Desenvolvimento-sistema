public class Tabuada {
   public Tabuada() {
   }

   public static void main(String[] var0) {
      for(int var1 = 1; var1 <= 10; ++var1) {
         for(int var2 = 1; var2 <= 10; ++var2) {
            int var3 = var1 * var2;
            System.out.println(var1 + "x" + var2 + "=" + var3);
         }

         System.out.println();
      }

   }
}
