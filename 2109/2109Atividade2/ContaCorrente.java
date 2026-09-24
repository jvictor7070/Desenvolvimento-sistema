public class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(int numero, String titular, double saldo, Agencia agencia) {
        super(numero, titular, saldo, agencia);
    }

    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }

        setSaldo(getSaldo() - valor);
        System.out.printf("Pagamento em dinheiro de R$ %.2f realizado com sucesso!%n", valor);
        System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
    }

    public void pagar(double valor, String chavePix) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }

        setSaldo(getSaldo() - valor);
        System.out.println("Pagamento via PIX realizado com sucesso!");
        System.out.println("Chave PIX utilizada: " + chavePix);
        System.out.printf("Valor pago: R$ %.2f%n", valor);
        System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
    }

    public void pagar(double valor, int parcelas) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da compra deve ser maior que zero.");
            return;
        }
        if (parcelas <= 0) {
            System.out.println("Erro: A quantidade de parcelas deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar o pagamento.");
            return;
        }

        double valorParcela = valor / parcelas;
        setSaldo(getSaldo() - valor);
        System.out.println("Pagamento no cartão realizado com sucesso!");
        System.out.println("Quantidade de parcelas: " + parcelas);
        System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);
        System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
    }

    public void transferir(double valor, int contaDestino) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser maior que zero.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar a transferência.");
            return;
        }

        setSaldo(getSaldo() - valor);
        System.out.printf("Transferência de R$ %.2f para a conta %d realizada com sucesso!%n", valor, contaDestino);
        System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
    }
}
