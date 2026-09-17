package contatos;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroContatos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contato> contatos = new ArrayList<>();

        while (true) {
            System.out.println("\n========= AGENDA DE CONTATOS =========");
            System.out.println("1 - Cadastrar contato pessoal");
            System.out.println("2 - Cadastrar contato profissional");
            System.out.println("3 - Cadastrar contato de emergência");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Pesquisar contato");
            System.out.println("6 - Alterar contato");
            System.out.println("7 - Excluir contato");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String numero = sc.nextLine();
                    System.out.print("Parentesco: ");
                    String parentesco = sc.nextLine();

                    contatos.add(new ContatoPessoal(nome, numero, parentesco));
                    System.out.println("Contato Pessoal cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String numero = sc.nextLine();
                    System.out.print("Empresa: ");
                    String empresa = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();

                    contatos.add(new ContatoProfissional(nome, numero, empresa, cargo));
                    System.out.println("Contato Profissional cadastrado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String numero = sc.nextLine();
                    System.out.print("Grau de Prioridade (Alta/Média/Baixa): ");
                    String prioridade = sc.nextLine();

                    contatos.add(new ContatoEmergencia(nome, numero, prioridade));
                    System.out.println("Contato de Emergência cadastrado com sucesso!");
                }
                case 4 -> {
                    System.out.println("\n--- Lista de Contatos ---");
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        for (int i = 0; i < contatos.size(); i++) {
                            System.out.println((i + 1) + " - " + contatos.get(i).exibirDados());
                            System.out.println("--------------------");
                        }
                    }
                }
                case 5 -> {
                    System.out.print("Digite o nome para pesquisar: ");
                    String busca = sc.nextLine();
                    boolean encontrado = false;

                    for (Contato c : contatos) {
                        if (c.getNome().equalsIgnoreCase(busca)) {
                            System.out.println("\nContato encontrado!");
                            System.out.println(c.exibirDados());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                    }
                }
                case 6 -> {
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado para alterar.");
                        break;
                    }

                    for (int i = 0; i < contatos.size(); i++) {
                        System.out.println((i + 1) + " - " + contatos.get(i).getNome());
                    }
                    System.out.print("Informe o número do contato que deseja alterar: ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    if (pos > 0 && pos <= contatos.size()) {
                        Contato contato = contatos.get(pos - 1);

                        System.out.print("Novo nome: ");
                        contato.setNome(sc.nextLine());

                        System.out.print("Novo telefone: ");
                        contato.setNumero(sc.nextLine());

                        System.out.println("Contato alterado com sucesso!");
                    } else {
                        System.out.println("Contato inválido!");
                    }
                }
                case 7 -> {
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado para excluir.");
                        break;
                    }

                    for (int i = 0; i < contatos.size(); i++) {
                        System.out.println((i + 1) + " - " + contatos.get(i).getNome());
                    }
                    System.out.print("Informe o número do contato que deseja excluir: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index > 0 && index <= contatos.size()) {
                        contatos.remove(index - 1);
                        System.out.println("Contato excluído com sucesso!");
                    } else {
                        System.out.println("Contato inválido!");
                    }
                }
                case 8 -> {
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}