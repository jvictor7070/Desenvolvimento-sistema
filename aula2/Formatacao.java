public class Formatacao {
    public static void main(String[] args) {
        String produto= "Teclado";
        int quantidade = 2;
        double preco = 89.90;

        System.out.printf("Produto: %s%n",produto);
        System.out.printf("Quantidade: %d%n",quantidade);
        System.out.printf("Preço: %.2f%n",preco);
    }
}
