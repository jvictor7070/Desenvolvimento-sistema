public class Carro extends Veiculo {

    public Carro(String placa, String modelo, int ano, double valorDiaria) {
        super(placa, modelo, ano, valorDiaria);
    }

    @Override
    public double calcularAluguel(int dias) {
        return getValorDiaria() * dias;
    }

    @Override
    public double calcularAluguel(int dias, double desconto) {
        return (getValorDiaria() * dias) - desconto;
    }
}
