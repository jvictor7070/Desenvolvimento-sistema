import java.util.Scanner;

public class VendasApp {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto = null;
        int quantidade = 0;
        double valorFinal = 0;

        while (true) {

        System.out.println("\n===== SISTEMA DE PRODUTOS =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Escolher produto físico ou digital");
        System.out.println("3 - Mostrar dados do produto");
        System.out.println("4 - Informar quantidade");
        System.out.println("5 - Realizar venda");
        System.out.println("6 - Realizar venda com desconto");
        System.out.println("7 - Mostrar valor final");
        System.out.println("8 - Encerrar programa");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

                case 1:

                System.out.println("\n--- CADASTRO DO PRODUTO ---");

                System.out.print("Código: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

               
                produto = new ProdutoFisico(
                 codigo,
                            nome,
                            preco,
                            0
                    );

                    System.out.println(
                            "Produto cadastrado com sucesso."
                    );

                    System.out.println(
                            "Escolha o tipo do produto na opção 2."
                    );

                    break;

                case 2:

                    if (produto == null) {

                        System.out.println(
                                "Cadastre o produto primeiro."
                        );

                        break;
                    }

                    System.out.println("\n--- TIPO DE PRODUTO ---");
                    System.out.println("1 - Produto Físico");
                    System.out.println("2 - Produto Digital");
                    System.out.print("Escolha o tipo: ");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        System.out.print(
                                "Informe o valor do frete: "
                        );

                        double frete = scanner.nextDouble();

                        produto = new ProdutoFisico(
                                produto.getCodigo(),
                                produto.getNome(),
                                produto.getPreco(),
                                frete
                        );

                        System.out.println(
                                "Produto definido como FÍSICO."
                        );

                    } else if (tipo == 2) {

                        produto = new ProdutoDigital(
                                produto.getCodigo(),
                                produto.getNome(),
                                produto.getPreco()
                        );

                        System.out.println(
                                "Produto definido como DIGITAL."
                        );

                    } else {

                        System.out.println(
                                "Tipo inválido."
                        );
                    }

                    break;

                case 3:

                    if (produto == null) {

                        System.out.println(
                                "Nenhum produto cadastrado."
                        );

                    } else {

                        System.out.println(
                                "\n--- DADOS DO PRODUTO ---"
                        );

                        produto.mostrarDados();

                        if (produto instanceof ProdutoFisico) {

                            System.out.println(
                                    "Tipo: Produto Físico"
                            );

                        } else if (
                                produto instanceof ProdutoDigital) {

                            System.out.println(
                                    "Tipo: Produto Digital"
                            );
                        }
                    }

                    break;

                case 4:

                    if (produto == null) {

                        System.out.println(
                                "Cadastre o produto primeiro."
                        );

                    } else {

                        System.out.print(
                                "Informe a quantidade: "
                        );

                        quantidade = scanner.nextInt();

                        System.out.println(
                                "Quantidade registrada: "
                                        + quantidade
                        );
                    }

                    break;

                case 5:

                    if (produto == null) {

                        System.out.println(
                                "Nenhum produto cadastrado."
                        );

                    } else if (quantidade <= 0) {

                        System.out.println(
                                "Informe a quantidade primeiro."
                        );

                    } else {

                        valorFinal =
                                produto.realizarVenda(
                                        quantidade
                                );

                        System.out.printf(
                                "Valor da venda: R$ %.2f%n",
                                valorFinal
                        );
                    }

                    break;

                case 6:

                    if (produto == null) {

                        System.out.println(
                                "Nenhum produto cadastrado."
                        );

                    } else if (quantidade <= 0) {

                        System.out.println(
                                "Informe a quantidade primeiro."
                        );

                    } else {

                        System.out.print(
                                "Informe o desconto (%): "
                        );

                        double desconto = scanner.nextDouble();

                        valorFinal =
                                produto.realizarVenda(
                                        quantidade,
                                        desconto
                                );

                        System.out.printf(
                                "Valor da venda com desconto: R$ %.2f%n",
                                valorFinal
                        );
                    }

                    break;

                case 7:

                    if (produto == null) {

                        System.out.println(
                                "Nenhum produto cadastrado."
                        );

                    } else {

                        System.out.printf(
                                "Valor final da compra: R$ %.2f%n",
                                valorFinal
                        );
                    }

                    break;

                case 8:

                    System.out.println(
                            "Programa encerrado."
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }
        }
    }
}
