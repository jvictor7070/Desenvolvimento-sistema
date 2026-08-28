import java.util.Scanner;

public class CadastroProdutos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaração do tamanho e vetores para armazenar os dados
        int tam = 10;
        String[] produtos = new String[tam];
        int[] quantidades = new int[tam];
        int qtd = 0; // Contador de produtos cadastrados

        int op;

        do {
            System.out.println("\n=== CADASTRO DE PRODUTOS ===");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Buscar produto(por nome)");
            System.out.println("4- Alterar produto(por nome)");
            System.out.println("5- Excluir produto(por nome)");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (qtd == tam) {
                        System.out.println("Lista Cheia");
                        break;
                    }
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int qtdInput = sc.nextInt();
                    sc.nextLine();

                    produtos[qtd] = nome;
                    quantidades[qtd] = qtdInput;
                    qtd++;

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    if (qtd == 0) {
                        System.out.println("Nenhum produto cadastrado");
                    } else {
                        System.out.println("\n--- Produtos ---");
                        for (int i = 0; i < qtd; i++) {
                            System.out.println(i + " - " + produtos[i] + " | Estoque: " + quantidades[i]);
                        }
                    }
                    break;

                case 3: // PESQUISAR POR NOME
                    System.out.print("Informe o nome: ");
                    String busca = sc.nextLine();

                    int posBusca = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(busca)) {
                            posBusca = i;
                            break;
                        }
                    }

                    if (posBusca == -1) {
                        System.out.println("Produto não encontrado");
                    } else {
                        System.out.println("Encontrado: " + produtos[posBusca] + " | Estoque: " + quantidades[posBusca]);
                    }
                    break;

                case 4://ALTERAR
    System.out.println("informe o nome para alterar: ");
    String nomeAlterar = sc.nextLine();

    int posAlt = -1;
    for(int i = 0; i < qtd; i++) {
        if (produtos[i].equalsIgnoreCase(nomeAlterar)) {
            posAlt = i;
            break;
        }
    }

    if (posAlt == -1) {
        System.out.println("Produto não encontrado!");
    } else {
        System.out.println("Novo nome: ");
        produtos[posAlt] = sc.nextLine();

        System.out.println("Nova quantidade: ");
        quantidades[posAlt] = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        System.out.println("Alterado com sucesso!");
    }
    break;

               case 5: // REMOVER
    System.out.println("informe o nome para remover: ");
    String nomeRemover = sc.nextLine();

    int posRem = -1;
    for (int i = 0; i < qtd; i++) {
        if (produtos[i].equalsIgnoreCase(nomeRemover)) {
            posRem = i;
            break;
        }
    }

    if (posRem == -1) {
        System.out.println("Produto não encontrado");
    } else {
        for (int i = posRem; i < qtd - 1; i++) {
            produtos[i] = produtos[i + 1];
            quantidades[i] = quantidades[i + 1];
        }
        produtos[qtd - 1] = null;
        quantidades[qtd - 1] = 0;
        qtd--;
        System.out.println("Removido com sucesso!");
    }
    break;

                case 0:
                    System.out.println("Partiu...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (op != 0);

        sc.close();
    }
}