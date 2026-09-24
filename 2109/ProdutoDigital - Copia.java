public class ProdutoDigital extends Produto {

    public ProdutoDigital(
            int codigo,
            String nome,
            double preco) {

        super(codigo, nome, preco);
    }

    @Override
    public double realizarVenda(int quantidade) {

        return getPreco() * quantidade;
    }

    @Override
    public double realizarVenda(int quantidade, double desconto) {

        double valorTotal = getPreco() * quantidade;

        return valorTotal - (valorTotal * desconto / 100);
    }
}
