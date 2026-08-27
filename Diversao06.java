import java.util.Scanner;
public class Diversao06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[5];
        int[] qtds = new int[5];
        int qtd = 0, op;

        do {
            System.out.print("\n1.Cadastrar | 2.Listar | 3.Pesquisar | 4.Alterar | 5.Remover | 6.Sair\nOpção: ");
            op = sc.nextInt(); 
            sc.nextLine();

            if (op == 1) {
                if (qtd < 5) {
                    System.out.print("Nome: "); nomes[qtd] = sc.nextLine();
                    System.out.print("Quantidade: "); qtds[qtd++] = sc.nextInt();
                    System.out.println("Cadastrado!");
                } else System.out.println("Limite atingido!");

            } else if (op == 2) {
                for (int i = 0; i < qtd; i++)
                    System.out.println("Índice " + i + ": " + nomes[i] + " - Qtd: " + qtds[i]);

            } else if (op >= 3 && op <= 5) {
                System.out.print("Nome do produto: ");
                String busca = sc.nextLine();
                int idx = -1;

                for (int i = 0; i < qtd; i++) {
                    if (nomes[i].equalsIgnoreCase(busca)) { idx = i; break; }
                }

                if (idx == -1) {
                    System.out.println("Não encontrado!");
                } else if (op == 3) {
                    System.out.println("Índice " + idx + ": " + nomes[idx] + " - Qtd: " + qtds[idx]);
                } else if (op == 4) {
                    System.out.print("Novo nome: "); nomes[idx] = sc.nextLine();
                    System.out.print("Nova quantidade: "); qtds[idx] = sc.nextInt();
                    System.out.println("Alterado!");
                } else if (op == 5) {
                    for (int j = idx; j < qtd - 1; j++) {
                        nomes[j] = nomes[j + 1];
                        qtds[j] = qtds[j + 1];
                    }
                    qtd--;
                    System.out.println("Removido!");
                }
            }
        } while (op != 6);

        sc.close();
    }
}

