import java.util.Scanner;

public class GerenciadorNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tam = 5; 
        int[] numeros = new int[tam];
        int qtd = 0; 

        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE NÚMEROS =====");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Listar números");
            System.out.println("3 - Remover número");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    if (qtd == tam) {
                        System.out.println("Array cheio! Não é possível inserir mais números.");
                    } else {
                        System.out.print("Digite o número a ser inserido: ");
                        int numero = sc.nextInt();
                        sc.nextLine();

                        numeros[qtd] = numero;
                        qtd++;
                        System.out.println("Número inserido com sucesso!");
                    }
                    break;

                case 2:
                   
                    if (qtd == 0) {
                        System.out.println("Nenhum número cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Números ---");
                        for (int i = 0; i < qtd; i++) {
                            System.out.println("Índice [" + i + "]: " + numeros[i]);
                        }
                    }
                    break;

                case 3:
                    
                    if (qtd == 0) {
                        System.out.println("Array vazio! Não há números para remover.");
                    } else {
                        System.out.print("Digite o índice que deseja remover (0 a " + (qtd - 1) + "): ");
                        int posRemover = sc.nextInt();
                        sc.nextLine();

                       
                        if (posRemover >= 0 && posRemover < qtd) {
                            
                            for (int i = posRemover; i < qtd - 1; i++) {
                                numeros[i] = numeros[i + 1];
                            }
                            qtd--; 
                            System.out.println("Número removido com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        sc.close();
    }
}