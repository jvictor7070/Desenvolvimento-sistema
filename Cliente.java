public class Cliente extends Pessoa implements Pagamento {

    // Construtor
    public Cliente(String nome) {
        super(nome);
    }

    // Método da Interface Pagamento
    @Override 
    public void pagar(double valor) {
        System.out.println("pagamento realizado: R$" + valor);
    }

    // Sobrecargas do método comprar
    public void comprar(String produto) {
        System.out.println("Produto Comprado: " + produto);
    }

    public void comprar(String produto, int quantidade) {
        System.out.println("Produto comprado: " + produto);
        System.out.println("Quantidade: " + quantidade);
    }

    public void comprar(String produto, int quantidade, double valor) {
        System.out.println("Produto comprado: " + produto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Unitario: " + valor);
        System.out.println("Total: " + (quantidade * valor));
    }

    // Método principal para testes
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");
        cliente.comprar("Camisa", 2, 50.0);
        cliente.pagar(100.0);
    }
}