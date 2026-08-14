public class Produto {
    public static void main(String[] args) {
        String produto = "Teclado";
        int quantidade  = 2;
        double preco_unitario = 75.50;

        System.out.printf(
            "  Produto: %s%n  Quantidade:%d%n  Preço Unitário: %.2f%n"
        ,produto,
        quantidade,
        preco_unitario);
    }
    
}
