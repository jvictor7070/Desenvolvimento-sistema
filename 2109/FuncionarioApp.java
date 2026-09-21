import java.util.Scanner;

public class FuncionarioApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Funcionario funcionario = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Escolher tipo de funcionário");
            System.out.println("3 - Mostrar dados cadastrados");
            System.out.println("4 - Calcular pagamento");
            System.out.println("5 - Calcular pagamento com bônus");
            System.out.println("6 - Consultar dados do funcionário");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- CADASTRO DO FUNCIONÁRIO ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();

                    System.out.println("\nFuncionário cadastrado com os dados básicos.");
                    System.out.println("Agora escolha o tipo do funcionário na opção 2.");

                    
                    funcionario = new FuncionarioCLT(nome, cpf, salario);

                    break;

                case 2:

                    if (funcionario == null) {
                        System.out.println("Cadastre o funcionário primeiro.");
                        break;
                    }

                    System.out.println("\n--- TIPO DE FUNCIONÁRIO ---");
                    System.out.println("1 - CLT");
                    System.out.println("2 - Freelancer");
                    System.out.print("Escolha o tipo: ");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        funcionario = new FuncionarioCLT(
                                funcionario.getNome(),
                                funcionario.getCpf(),
                                funcionario.getSalario()
                        );

                        System.out.println("Funcionário definido como CLT.");

                    } else if (tipo == 2) {

                        System.out.print("Quantidade de horas trabalhadas: ");
                        double horas = scanner.nextDouble();

                        System.out.print("Valor recebido por hora: ");
                        double valorHora = scanner.nextDouble();

                        funcionario = new FuncionarioFreelancer(
                                funcionario.getNome(),
                                funcionario.getCpf(),
                                funcionario.getSalario(),
                                horas,
                                valorHora
                        );

                        System.out.println("Funcionário definido como Freelancer.");

                    } else {
                        System.out.println("Tipo inválido.");
                    }

                    break;

                case 3:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        System.out.println("\n--- DADOS CADASTRADOS ---");
                        funcionario.mostrarDados();
                    }

                    break;

                case 4:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        double pagamento = funcionario.calcularPagamento();

                        System.out.printf(
                                "Pagamento: R$ %.2f%n",
                                pagamento
                        );
                    }

                    break;

                case 5:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        System.out.print("Digite o valor do bônus: ");
                        double bonus = scanner.nextDouble();

                        double pagamentoComBonus =
                                funcionario.calcularPagamento(bonus);

                        System.out.printf(
                                "Pagamento com bônus: R$ %.2f%n",
                                pagamentoComBonus
                        );
                    }

                    break;

                case 6:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        System.out.println("\n--- CONSULTA DO FUNCIONÁRIO ---");
                        funcionario.mostrarDados();

                        if (funcionario instanceof FuncionarioCLT) {
                            System.out.println("Tipo: CLT");

                        } else if (funcionario instanceof FuncionarioFreelancer) {
                            System.out.println("Tipo: Freelancer");
                        }
                    }

                    break;

                case 7:

                    System.out.println("Fuuuuuui.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

