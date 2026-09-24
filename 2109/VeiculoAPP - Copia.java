import java.util.Scanner;

public class VeiculoAPP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Veiculo veiculo = null;
        int dias = 0;

        while (true) {

            System.out.println("\n===== SISTEMA DE LOCAÇÃO DE VEÍCULOS =====");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Escolher entre carro ou moto");
            System.out.println("3 - Mostrar dados do veículo");
            System.out.println("4 - Informar quantidade de dias");
            System.out.println("5 - Calcular valor do aluguel");
            System.out.println("6 - Calcular aluguel com desconto");
            System.out.println("7 - Encerrar programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRO DO VEÍCULO ---");

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();

                    System.out.print("Valor da diária: ");
                    double valorDiaria = scanner.nextDouble();

                    
                    veiculo = new Carro(
                            placa,
                            modelo,
                            ano,
                            valorDiaria
                    );

                    System.out.println("Veículo cadastrado com sucesso.");
                    System.out.println("Escolha o tipo do veículo na opção 2.");

                    break;

                case 2:

                    if (veiculo == null) {
                        System.out.println("Cadastre o veículo primeiro.");
                        break;
                    }

                    System.out.println("\n--- TIPO DE VEÍCULO ---");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("Escolha o tipo: ");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        veiculo = new Carro(
                                veiculo.getPlaca(),
                                veiculo.getModelo(),
                                veiculo.getAno(),
                                veiculo.getValorDiaria()
                        );

                        System.out.println("Veículo definido como CARRO.");

                    } else if (tipo == 2) {

                        veiculo = new Moto(
                                veiculo.getPlaca(),
                                veiculo.getModelo(),
                                veiculo.getAno(),
                                veiculo.getValorDiaria()
                        );

                        System.out.println("Veículo definido como MOTO.");

                    } else {
                        System.out.println("Tipo inválido.");
                    }

                    break;

                case 3:

                    if (veiculo == null) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {

                        System.out.println("\n--- DADOS DO VEÍCULO ---");

                        veiculo.mostrarDados();

                        if (veiculo instanceof Carro) {
                            System.out.println("Tipo: Carro");
                        } else if (veiculo instanceof Moto) {
                            System.out.println("Tipo: Moto");
                        }
                    }

                    break;

                case 4:

                    if (veiculo == null) {
                        System.out.println("Cadastre o veículo primeiro.");
                    } else {

                        System.out.print("Informe a quantidade de dias: ");
                        dias = scanner.nextInt();

                        System.out.println(
                                "Quantidade de dias registrada: " + dias
                        );
                    }

                    break;

                case 5:

                    if (veiculo == null) {
                        System.out.println("Nenhum veículo cadastrado.");

                    } else if (dias <= 0) {
                        System.out.println(
                                "Informe a quantidade de dias primeiro."
                        );

                    } else {

                        double valorAluguel =
                                veiculo.calcularAluguel(dias);

                        System.out.printf(
                                "Valor do aluguel: R$ %.2f%n",
                                valorAluguel
                        );
                    }

                    break;

                case 6:

                    if (veiculo == null) {
                        System.out.println("Nenhum veículo cadastrado.");

                    } else if (dias <= 0) {
                        System.out.println(
                                "Informe a quantidade de dias primeiro."
                        );

                    } else {

                        System.out.print("Informe o valor do desconto: ");
                        double desconto = scanner.nextDouble();

                        double valorFinal =
                                veiculo.calcularAluguel(
                                        dias,
                                        desconto
                                );

                        System.out.printf(
                                "Valor do aluguel com desconto: R$ %.2f%n",
                                valorFinal
                        );
                    }

                    break;

                case 7:

                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}
