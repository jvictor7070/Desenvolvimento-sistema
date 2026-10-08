import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CaixaGerenciadorArquivos {

    public static void main(String[] args) {
        File pastaLab = new File("LABORATORIO");
        if (!pastaLab.exists()) {
            pastaLab.mkdir();
        }

        boolean rodando = true;

        while (rodando) {
            String menu = " GERENCIADOR DE ARQUIVOS \n"
                    + "1 - Criar arquivo\n"
                    + "2 - Escrever no arquivo\n"
                    + "3 - Ler arquivo\n"
                    + "4 - Renomear arquivo\n"
                    + "5 - Excluir arquivo\n"
                    + "6 - Mostrar informações do arquivo\n"
                    + "7 - Tornar arquivo somente leitura\n"
                    + "8 - Sair\n\n"
                    + "Digite a opção desejada:";

            String opcaoTexto = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            if (opcaoTexto == null) {
                break;
            }

            try {
                int opcao = Integer.parseInt(opcaoTexto.trim());

                switch (opcao) {
                    case 1:
                        criarArquivo();
                        break;
                    case 2:
                        escreverArquivo();
                        break;
                    case 3:
                        lerArquivo();
                        break;
                    case 4:
                        renomearArquivo();
                        break;
                    case 5:
                        excluirArquivo();
                        break;
                    case 6:
                        mostrarInformacoes();
                        break;
                    case 7:
                        protegerArquivo();
                        break;
                    case 8:
                        rodando = false;
                        JOptionPane.showMessageDialog(null, "Sistema encerrado!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido!");
            }
        }
    }

    public static void criarArquivo() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo (ex: atividade.txt):");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo já existe!");
        } else {
            try {
                if (arq.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao criar arquivo.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }

    public static void escreverArquivo() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        if (!arq.canWrite()) {
            JOptionPane.showMessageDialog(null, "O arquivo é somente leitura e não pode ser alterado!");
            return;
        }

        String texto = JOptionPane.showInputDialog("Digite o texto para gravar:");
        if (texto == null) {
            return;
        }

        try {
            FileWriter fw = new FileWriter(arq, true);
            fw.write(texto + "\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "Texto gravado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void lerArquivo() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo para ler:");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        try {
            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            String textoCompleto = "";

            while ((linha = br.readLine()) != null) {
                textoCompleto = textoCompleto + linha + "\n";
            }

            br.close();
            fr.close();

            if (textoCompleto.equals("")) {
                JOptionPane.showMessageDialog(null, "O arquivo está vazio!");
            } else {
                JOptionPane.showMessageDialog(null, textoCompleto, "Conteúdo do Arquivo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public static void renomearArquivo() {
        String nomeAtual = JOptionPane.showInputDialog("Digite o nome atual do arquivo:");
        if (nomeAtual == null || nomeAtual.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arqAtual = new File("LABORATORIO/" + nomeAtual.trim());
        if (!arqAtual.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do arquivo:");
        if (novoNome == null || novoNome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Novo nome inválido!");
            return;
        }

        File arqNovo = new File("LABORATORIO/" + novoNome.trim());
        if (arqNovo.exists()) {
            JOptionPane.showMessageDialog(null, "Já existe um arquivo com esse novo nome!");
            return;
        }

        if (arqAtual.renameTo(arqNovo)) {
            JOptionPane.showMessageDialog(null, "Arquivo renomeado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao renomear arquivo.");
        }
    }

    public static void excluirArquivo() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo para excluir:");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir " + nome + "?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            if (arq.delete()) {
                JOptionPane.showMessageDialog(null, "Arquivo excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir arquivo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
        }
    }

    public static void mostrarInformacoes() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        String extensao = "Sem extensão";
        if (nome.contains(".")) {
            extensao = nome.substring(nome.lastIndexOf(".") + 1);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataModificacao = sdf.format(new Date(arq.lastModified()));

        String info = "Informações do Arquivo:\n\n"
                + "Nome: " + arq.getName() + "\n"
                + "Extensão: " + extensao + "\n"
                + "Tamanho: " + arq.length() + " bytes\n"
                + "Caminho: " + arq.getAbsolutePath() + "\n"
                + "Pode ler: " + (arq.canRead() ? "Sim" : "Não") + "\n"
                + "Pode escrever: " + (arq.canWrite() ? "Sim" : "Não") + "\n"
                + "Pode executar: " + (arq.canExecute() ? "Sim" : "Não") + "\n"
                + "Última modificação: " + dataModificacao;

        JOptionPane.showMessageDialog(null, info);
    }

    public static void protegerArquivo() {
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo para deixar Somente Leitura:");
        if (nome == null || nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            return;
        }

        File arq = new File("LABORATORIO/" + nome.trim());
        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe!");
            return;
        }

        if (arq.setReadOnly()) {
            JOptionPane.showMessageDialog(null, "Arquivo alterado para somente leitura!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a permissão.");
        }
    }
}