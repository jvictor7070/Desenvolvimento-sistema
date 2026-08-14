public class Nota_Fiscal {
    public static void main(String[] args) {
        String nome ="João Victor";
        String produto = "Mouse";
        int quantidade = 2 ;
        double valor= 45.90;
        double total =  quantidade * valor;

        System.out.printf(
            "---------NOTA FISCAL--------%n%n Nome:%s%n Produto:%s%n Quantidade:%d%n Valor:%.2f%n Total:%.2f%n -----------------%n%n "
            ,nome,produto,quantidade,valor,total);
        
    }
    
}
