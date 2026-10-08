package caixaveiculo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CaixaPrincipal {
    private static final List<CaixaCarro> listaCarros = new ArrayList<>();

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            String menu = "=== SISTEMA DE CADASTRO DE CARROS ===\n\n"
                    + "1 - Cadastrar Carro\n"
                    + "2 - Listar Carros\n"
                    + "3 - Detalhar Carro\n"
                    + "4 - Alterar Carro\n"
                    + "5 - Remover Carro\n"
                    + "6 - Gravar Informações em Arquivo\n"
                    + "7 - Sair\n\n"
                    + "Escolha uma opção:";

            String opcaoInput = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            if (opcaoInput == null) {
                break;
            }

            try {
                int opcao = Integer.parseInt(opcaoInput.trim());

                switch (opcao) {
                    case 1 -> cadastrarCarro();
                    case 2 -> listarCarros();
                    case 3 -> detalharCarro();
                    case 4 -> alterarCarro();
                    case 5 -> removerCarro();
                    case 6 -> gravarEmArquivo();
                    case 7 -> {
                        executando = false;
                        JOptionPane.showMessageDialog(null, "Sistema encerrado.", "Sair", JOptionPane.INFORMATION_MESSAGE);
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um valor de 1 a 7.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número inteiro.", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void cadastrarCarro() {
        String marca = JOptionPane.showInputDialog(null, "Informe a marca do carro:", "Cadastrar", JOptionPane.QUESTION_MESSAGE);
        if (marca == null || marca.trim().isEmpty()) return;

        String modelo = JOptionPane.showInputDialog(null, "Informe o modelo do carro:", "Cadastrar", JOptionPane.QUESTION_MESSAGE);
        if (modelo == null || modelo.trim().isEmpty()) return;

        String anoInput = JOptionPane.showInputDialog(null, "Informe o ano do carro:", "Cadastrar", JOptionPane.QUESTION_MESSAGE);
        if (anoInput == null) return;

        try {
            int ano = Integer.parseInt(anoInput.trim());
            listaCarros.add(new CaixaCarro(marca.trim(), modelo.trim(), ano));
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido! Cadastro cancelado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarCarros() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado no momento.", "Lista de Carros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("=== CARROS CADASTRADOS ===\n\n");
        for (int i = 0; i < listaCarros.size(); i++) {
            CaixaCarro carro = listaCarros.get(i);
            sb.append(i + 1)
              .append(". Marca: ").append(carro.getMarca())
              .append(" | Modelo: ").append(carro.getModelo())
              .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Carros", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void detalharCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro disponível para detalhar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Detalhar Carro");
        if (indice != -1) {
            CaixaCarro carro = listaCarros.get(indice);
            JOptionPane.showMessageDialog(null, carro.exibirDetalhes(), "Detalhes do Carro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterarCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro disponível para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Alterar Carro");
        if (indice != -1) {
            CaixaCarro carro = listaCarros.get(indice);

            String novaMarca = JOptionPane.showInputDialog(null, "Marca atual: " + carro.getMarca() + "\nDigite a nova marca:", carro.getMarca());
            if (novaMarca == null || novaMarca.trim().isEmpty()) return;

            String novoModelo = JOptionPane.showInputDialog(null, "Modelo atual: " + carro.getModelo() + "\nDigite o novo modelo:", carro.getModelo());
            if (novoModelo == null || novoModelo.trim().isEmpty()) return;

            String novoAnoInput = JOptionPane.showInputDialog(null, "Ano atual: " + carro.getAno() + "\nDigite o novo ano:", carro.getAno());
            if (novoAnoInput == null) return;

            try {
                int novoAno = Integer.parseInt(novoAnoInput.trim());
                carro.setMarca(novaMarca.trim());
                carro.setModelo(novoModelo.trim());
                carro.setAno(novoAno);
                JOptionPane.showMessageDialog(null, "Dados do carro atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano inválido! A alteração foi descartada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void removerCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro disponível para remoção.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Remover Carro");
        if (indice != -1) {
            CaixaCarro removido = listaCarros.remove(indice);
            JOptionPane.showMessageDialog(null, "Carro " + removido.getModelo() + " removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void gravarEmArquivo() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há carros cadastrados para gravar no arquivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileWriter fw = new FileWriter("carros.txt");
             PrintWriter pw = new PrintWriter(fw)) {

            for (CaixaCarro c : listaCarros) {
                pw.println("Marca: " + c.getMarca());
                pw.println("Modelo: " + c.getModelo());
                pw.println("Ano: " + c.getAno());
                pw.println("----------------------------------------");
            }

            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso no arquivo 'carros.txt'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo: " + e.getMessage(), "Erro de E/S", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static int selecionarIndiceCarro(String tituloAcao) {
        StringBuilder sb = new StringBuilder("Informe o número do carro desejado:\n\n");
        for (int i = 0; i < listaCarros.size(); i++) {
            CaixaCarro carro = listaCarros.get(i);
            sb.append(i + 1).append(" - ").append(carro.getMarca()).append(" ").append(carro.getModelo()).append("\n");
        }

        String input = JOptionPane.showInputDialog(null, sb.toString(), tituloAcao, JOptionPane.QUESTION_MESSAGE);
        if (input == null) return -1;

        try {
            int numero = Integer.parseInt(input.trim());
            int indice = numero - 1;

            if (indice >= 0 && indice < listaCarros.size()) {
                return indice;
            } else {
                JOptionPane.showMessageDialog(null, "Número informado fora do intervalo válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, informe apenas o número correspondente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}