public class TryExcept02 {
    public static void main(String[] args) {
        int [] numeros={10,20,30};

        try {
            System.out.println(numeros[1]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: índice fora do limite");
        }
        finally{
            System.err.println("Fim do programa");
        }
    }
    
}
