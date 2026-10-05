import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AtvManipulaca {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n1 - Criar arquivo");
            System.out.println("2 - Escrever no arquivo");
            System.out.println("3 - Ler arquivo");
            System.out.println("4 - Alterar arquivo");
            System.out.println("5 - Remover arquivo");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    try {
                        File arquivo = new File("arquivo.txt");
                        if (arquivo.createNewFile()) {
                            System.out.println("Arquivo criado com sucesso! " + arquivo.getName());
                        } else {
                            System.out.println("Arquivo já existe!");
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao criar arquivo: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Digite o conteúdo para escrever: ");
                        String texto = sc.nextLine();
                        FileWriter writer = new FileWriter("arquivo.txt");
                        writer.write(texto + "\n");
                        writer.close();
                        System.out.println("Conteúdo escrito com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao escrever arquivo! " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
                        String linha;
                        System.out.println("(conteúdo do arquivo)");
                        while ((linha = reader.readLine()) != null) {
                            System.out.println(linha);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Erro ao ler arquivo! " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Digite o texto para adicionar ao arquivo: ");
                        String textoAdicional = sc.nextLine();
                        FileWriter fw = new FileWriter("arquivo.txt", true);
                        fw.write(textoAdicional + "\n");
                        fw.close();
                        System.out.println("Conteúdo alterado com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao alterar o arquivo " + e.getMessage());
                    }
                    break;

                case 5:
                    File arquivo = new File("arquivo.txt");
                    if (arquivo.delete()) {
                        System.out.println("Arquivo deletado com sucesso!");
                    } else {
                        System.out.println("Erro ao deletar arquivo!");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        sc.close();
    }
}

