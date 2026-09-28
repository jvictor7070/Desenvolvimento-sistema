public class TryExcept01 {
    public static void main(String[] args) {
        
        int a =10;
        int b=2;

        try{
        int resultado=a/b;
        System.out.println("Resultado:"+resultado);
    }catch(ArithmeticException e){
    System.out.println("Erro: não é possível dividir por zero!");
    }
    finally{
    System.out.println("Tchau meu bemzinho");}
    }
    
}
