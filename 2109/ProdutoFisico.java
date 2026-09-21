public class ProdutoFisico extends Produto {

    private double frete;

    public ProdutoFisico(
            int codigo,
            String nome,
            double preco,
            double frete) {

        super(codigo, nome, preco);
        this.frete = frete;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    @Override
    public double realizarVenda(int quantidade) {

        double valorProdutos = getPreco() * quantidade;

        return valorProdutos + frete;
    }

    @Override
    public double realizarVenda(int quantidade, double desconto) {

        double valorProdutos = getPreco() * quantidade;

        double valorComDesconto =
                valorProdutos - (valorProdutos * desconto / 100);

        return valorComDesconto + frete;
    }

    @Override
    public void mostrarDados() {

        super.mostrarDados();

        System.out.printf(
                "Frete: R$ %.2f%n",
                frete
        );
    }
}
