public class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private Agencia agencia;

    public Conta(int numero, String titular, double saldo, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            System.out.printf("Novo saldo: R$ %.2f%n", this.saldo);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", this.saldo);
    }

    public void mostrarDados() {
        agencia.mostrarDados();
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo Atual: R$ %.2f%n", saldo);
    }
}
