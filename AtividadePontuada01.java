import java.util.Scanner;

public class AtividadePontuada01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max_avioes = 4;
        int max_assentos = 20;

        int[] numerosAvioes = new int[max_avioes];
        int[] assentosAvioes = new int[max_avioes];
        String[] nomesPassageiros = new String[max_assentos];
        int[] avioesReservas = new int[max_assentos];

        int avioesCadastrados = 0;
        int totalReservas = 0;
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("=========================\nSWEET FLIGHT – SISTEMA DE RESERVAS\n=========================");
            System.out.println("1 - Cadastrar aviões");
            System.out.println("2 - Cadastrar quantidade de assentos");
            System.out.println("3 - Listar aviões");
            System.out.println("4 - Realizar reserva");
            System.out.println("5 - Consultar reservas de um avião");
            System.out.println("6 - Pesquisar passageiro");
            System.out.println("7 - Mostrar resumo");
            System.out.println("8 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            if (opcao < 1 || opcao > 8) {
                System.out.println("Opção inválida, Digite os números presentes no menu!");
              
            }

            switch (opcao) {
                case 1:
                    int quantidade = 0;
                    while (quantidade < 1 || quantidade > 4) {
                        System.out.print("Quantos aviões deseja cadastrar (máximo: 4)? ");
                        quantidade = sc.nextInt();
                    }

                    avioesCadastrados = quantidade;

                    for (int i = 0; i < avioesCadastrados; i++) {
                        int numAviao;
                        boolean duplicado;
                        do {
                            duplicado = false;
                            System.out.print("Informe o número do avião " + (i + 1) + ": ");
                            numAviao = sc.nextInt();

                            for (int x = 0; x < i; x++) {
                                if (numerosAvioes[x] == numAviao) {
                                    duplicado = true;
                                    System.out.println("Esse avião já foi cadastrado! Tente outro.");
                                    break;
                                }
                            }
                        } while (duplicado);

                        numerosAvioes[i] = numAviao;
                    }
                    System.out.println("Aviões cadastrados com sucesso!");
                    break;

                case 2:
                    if (avioesCadastrados == 0) {
                        System.out.println("Nenhum avião cadastrado.");
                        break;
                    }

                    for (int i = 0; i < avioesCadastrados; i++) {
                        int assentos = -1;
                        while (assentos < 0 || assentos > 20) {
                            System.out.print("Informe a quantidade de assentos para o avião " + numerosAvioes[i] + " (0 a 20): ");
                            assentos = sc.nextInt();
                        }
                        assentosAvioes[i] = assentos;
                    }
                    System.out.println("Assentos cadastrados com sucesso!");
                    break;

                case 3:
                    if (avioesCadastrados == 0) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        for (int i = 0; i < avioesCadastrados; i++) {
                            System.out.println("Avião: " + numerosAvioes[i] + ", Assentos disponíveis: " + assentosAvioes[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Informe o número do avião desejado: ");
                    int numeroDesejado = sc.nextInt();
                    sc.nextLine(); 

                    int indiceAviao = -1;
                    for (int i = 0; i < avioesCadastrados; i++) {
                        if (numerosAvioes[i] == numeroDesejado) {
                            indiceAviao = i;
                            break;
                        }
                    }

                    if (indiceAviao == -1) {
                        System.out.println("Este avião não existe!");
                    } else if (assentosAvioes[indiceAviao] <= 0) {
                        System.out.println("Não há assentos disponíveis para este avião!");
                    } else if (totalReservas >= 20) {
                        System.out.println("Limite máximo de 20 reservas atingido!");
                    } else {
                        String nomePassageiro = "";
                        while (nomePassageiro.trim().isEmpty()) {
                            System.out.print("Informe o nome do passageiro: ");
                            nomePassageiro = sc.nextLine();
                        }

                        nomesPassageiros[totalReservas] = nomePassageiro;
                        avioesReservas[totalReservas] = numeroDesejado;
                        assentosAvioes[indiceAviao]--;
                        totalReservas++;

                        System.out.println("Reserva realizada com sucesso!");
                    }
                    break;

                case 5:
                    System.out.print("Informe o número do avião: ");
                    int aviaoConsulta = sc.nextInt();

                    boolean aviaoExiste = false;
                    for (int i = 0; i < avioesCadastrados; i++) {
                        if (numerosAvioes[i] == aviaoConsulta) {
                            aviaoExiste = true;
                            break;
                        }
                    }

                    if (!aviaoExiste) {
                        System.out.println("Este avião não existe!");
                    } else {
                        boolean encontrouReserva = false;
                        for (int i = 0; i < totalReservas; i++) {
                            if (avioesReservas[i] == aviaoConsulta) {
                                System.out.println("Passageiro: " + nomesPassageiros[i]);
                                encontrouReserva = true;
                            }
                        }
                        if (!encontrouReserva) {
                            System.out.println("Não há reservas realizadas para este avião!");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Informe o nome do passageiro: ");
                    String nomeBusca = sc.nextLine();

                    boolean passageiroEncontrado = false;
                    for (int i = 0; i < totalReservas; i++) {
                        if (nomesPassageiros[i].equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Reserva para o avião número: " + avioesReservas[i]);
                            passageiroEncontrado = true;
                        }
                    }

                    if (!passageiroEncontrado) {
                        System.out.println("Não há reservas realizadas para este passageiro!");
                    }
                    break;

                case 7:
                    int totalAssentosDisponiveis = 0;
                    int avioesComAssentos = 0;
                    int avioesSemAssentos = 0;
                    int maiorAssentos = -1;
                    int aviaoMaiorAssentos = -1;

                    for (int i = 0; i < avioesCadastrados; i++) {
                        totalAssentosDisponiveis += assentosAvioes[i];

                        if (assentosAvioes[i] > 0) {
                            avioesComAssentos++;
                        } else {
                            avioesSemAssentos++;
                        }

                        if (assentosAvioes[i] > maiorAssentos) {
                            maiorAssentos = assentosAvioes[i];
                            aviaoMaiorAssentos = numerosAvioes[i];
                        }
                    }

                    System.out.println("--- RESUMO ---");
                    System.out.println("Quantidade de aviões cadastrados: " + avioesCadastrados);
                    System.out.println("Quantidade total de reservas realizadas: " + totalReservas);
                    System.out.println("Quantidade total de assentos disponíveis: " + totalAssentosDisponiveis);
                    System.out.println("Quantidade de aviões com assentos disponíveis: " + avioesComAssentos);
                    System.out.println("Quantidade de aviões sem assentos disponíveis: " + avioesSemAssentos);
                    if (avioesCadastrados > 0) {
                        System.out.println("Avião com maior quantidade de assentos disponíveis: " + aviaoMaiorAssentos + " (" + maiorAssentos + " assentos)");
                    }
                    break;

                case 8:
                    System.out.println("Sistema encerrado!!!");
                    break;
            }
        }

        sc.close();
    }
}