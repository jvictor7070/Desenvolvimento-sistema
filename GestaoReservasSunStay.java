import java.util.Scanner;

public class GestaoReservasSunStay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdQuartos = 0;
        do {
            System.out.print("Informe a quantidade de quartos disponíveis no hotel (máximo 5): ");
            qtdQuartos = sc.nextInt();
            sc.nextLine();

            if (qtdQuartos < 1 || qtdQuartos > 5) {
                System.out.println("Quantidade inválida! O hotel pode possuir de 1 a no máximo 5 quartos.\n");
            }
        } while (qtdQuartos < 1 || qtdQuartos > 5);

        int[] numerosQuartos = new int[qtdQuartos];
        int[] camasQuartos = new int[qtdQuartos];
        boolean quartosRegistrados = false;
        boolean camasRegistradas = false;

        int maxReservas = 25;
        int[] reservasQuarto = new int[maxReservas];
        String[] reservasHospede = new String[maxReservas];
        int totalReservas = 0;

        int opcao;

        do {
            System.out.println("\n===== SUNSTAY HOTELS - MENU =====");
            System.out.println("1 – Registrar número dos quartos");
            System.out.println("2 – Registrar quantidade de camas");
            System.out.println("3 – Reservar quarto");
            System.out.println("4 – Consultar reservas por quarto");
            System.out.println("5 – Consultar reservas por hóspede");
            System.out.println("6 – Encerrar sistema");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- 1. Registrar número dos quartos ---");
                    for (int i = 0; i < qtdQuartos; i++) {
                        System.out.print("Informe o número do Quarto " + (i + 1) + ": ");
                        numerosQuartos[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    quartosRegistrados = true;
                    System.out.println("Números dos quartos registrados com sucesso!");
                    break;

                case 2:
                    if (!quartosRegistrados) {
                        System.out.println("\nPor favor, registre os números dos quartos primeiro (Opção 1).");
                        break;
                    }
                    System.out.println("\n--- 2. Registrar quantidade de camas ---");
                    for (int i = 0; i < qtdQuartos; i++) {
                        System.out.print("Quarto " + numerosQuartos[i] + " -> Quantidade de camas: ");
                        camasQuartos[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    camasRegistradas = true;
                    System.out.println("Quantidade de camas registrada com sucesso!");
                    break;

                case 3:
                    if (!quartosRegistrados || !camasRegistradas) {
                        System.out.println("\nPor favor, realize os registros de quartos e camas (Opções 1 e 2) antes de fazer reservas!");
                        break;
                    }
                    if (totalReservas >= maxReservas) {
                        System.out.println("\nLimite máximo de reservas (25) atingido!");
                        break;
                    }

                    System.out.println("\n--- 3. Reservar quarto ---");
                    System.out.print("Informe o número do quarto: ");
                    int numQuartoReserva = sc.nextInt();
                    sc.nextLine();

                    int posQuarto = -1;
                    for (int i = 0; i < qtdQuartos; i++) {
                        if (numerosQuartos[i] == numQuartoReserva) {
                            posQuarto = i;
                            break;
                        }
                    }

                    if (posQuarto == -1) {
                        System.out.println("Este quarto não existe!");
                    } else if (camasQuartos[posQuarto] <= 0) {
                        System.out.println("Não há camas disponíveis neste quarto!");
                    } else {
                        System.out.print("Informe o nome do hóspede: ");
                        String nomeHospede = sc.nextLine();

                        reservasQuarto[totalReservas] = numQuartoReserva;
                        reservasHospede[totalReservas] = nomeHospede;
                        totalReservas++;

                        camasQuartos[posQuarto]--;

                        System.out.println("Reserva realizada com sucesso!");
                    }
                    break;

                case 4:
                    if (!quartosRegistrados) {
                        System.out.println("\nNenhum quarto cadastrado até o momento!");
                        break;
                    }
                    System.out.println("\n--- 4. Consultar reservas por quarto ---");
                    System.out.print("Informe o número do quarto: ");
                    int numQuartoConsulta = sc.nextInt();
                    sc.nextLine();

                    boolean quartoExiste = false;
                    for (int i = 0; i < qtdQuartos; i++) {
                        if (numerosQuartos[i] == numQuartoConsulta) {
                            quartoExiste = true;
                            break;
                        }
                    }

                    if (!quartoExiste) {
                        System.out.println("Este quarto não existe!");
                    } else {
                        boolean temReserva = false;
                        for (int i = 0; i < totalReservas; i++) {
                            if (reservasQuarto[i] == numQuartoConsulta) {
                                System.out.println("Hóspede: " + reservasHospede[i]);
                                temReserva = true;
                            }
                        }
                        if (!temReserva) {
                            System.out.println("Não há reservas para este quarto!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- 5. Consultar reservas por hóspede ---");
                    System.out.print("Informe o nome do hóspede: ");
                    String nomeConsulta = sc.nextLine();

                    boolean encontrouHospede = false;
                    for (int i = 0; i < totalReservas; i++) {
                        if (reservasHospede[i].equalsIgnoreCase(nomeConsulta)) {
                            System.out.println("Reserva no Quarto: " + reservasQuarto[i]);
                            encontrouHospede = true;
                        }
                    }

                    if (!encontrouHospede) {
                        System.out.println("Não há reservas para este hóspede!");
                    }
                    break;

                case 6:
                    System.out.println("\nEncerrando sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 6);

        sc.close();
    }
}