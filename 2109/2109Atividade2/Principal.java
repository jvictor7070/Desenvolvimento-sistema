import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CADASTRO INICIAL ===");
        System.out.print("Número da agência: ");
        int numAgencia = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        System.out.print("Nome da agência: ");
        String nomeAgencia = sc.nextLine();

        System.out.print("Número da conta: ");
        int numConta = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        System.out.print("Nome do titular: ");
        String titular = sc.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = sc.nextDouble();

        // Criando as instâncias
        Agencia agencia = new Agencia(numAgencia, nomeAgencia);
        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao = -1;

        // Menu de repetição
        do {
            System.out.println("\n================ MENU ================");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("7 - Transferir (Desafio)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n--- DADOS DA CONTA ---");
                    conta.mostrarDados();
                    break;
                case 2:
                    System.out.println("\n--- CONSULTA DE SALDO ---");
                    conta.consultarSaldo();
                    break;
                case 3:
                    System.out.println("\n--- DEPÓSITO ---");
                    System.out.print("Informe o valor do depósito: R$ ");
                    double vDeposito = sc.nextDouble();
                    conta.depositar(vDeposito);
                    break;
                case 4:
                    System.out.println("\n--- PAGAMENTO VIA PIX ---");
                    System.out.print("Informe o valor do pagamento: R$ ");
                    double vPix = sc.nextDouble();
                    sc.nextLine(); // Limpa o buffer
                    System.out.print("Informe a chave PIX: ");
                    String chave = sc.nextLine();
                    conta.pagar(vPix, chave);
                    break;
                case 5:
                    System.out.println("\n--- PAGAMENTO COM CARTÃO ---");
                    System.out.print("Informe o valor da compra: R$ ");
                    double vCartao = sc.nextDouble();
                    System.out.print("Informe a quantidade de parcelas: ");
                    int parcelas = sc.nextInt();
                    conta.pagar(vCartao, parcelas);
                    break;
                case 6:
                    System.out.println("\n--- PAGAMENTO EM DINHEIRO ---");
                    System.out.print("Informe o valor do pagamento: R$ ");
                    double vDinheiro = sc.nextDouble();
                    conta.pagar(vDinheiro);
                    break;
                case 7:
                    System.out.println("\n--- TRANSFERÊNCIA ---");
                    System.out.print("Informe o número da conta de destino: ");
                    int cDestino = sc.nextInt();
                    System.out.print("Informe o valor da transferência: R$ ");
                    double vTransferencia = sc.nextDouble();
                    conta.transferir(vTransferencia, cDestino);
                    break;
                case 0:
                    System.out.println("\nPrograma encerrado com sucesso.");
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha uma opção do menu.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}