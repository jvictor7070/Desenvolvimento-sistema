package com.example;

import javax.swing.JOptionPane;
import java.util.List;

/**
 * Interface gráfica com JOptionPane - Menu, caixas de entrada e validações.
 */
public class EletrodomesticoView {

    private final EletrodomesticoControle controle = new EletrodomesticoControle();

    public void iniciarMenu() {
        boolean rodando = true;

        while (rodando) {
            String opStr = JOptionPane.showInputDialog(
                    null,
                    "=== MENU PRINCIPAL ===\n\n"
                            + "1. Cadastrar eletrodoméstico\n"
                            + "2. Listar eletrodomésticos\n"
                            + "3. Alterar eletrodoméstico\n"
                            + "4. Remover eletrodoméstico\n"
                            + "5. Sair\n\n"
                            + "Digite o número da opção desejada:",
                    "Cadastro de Eletrodomésticos",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Fechou ou cancelou no menu
            if (opStr == null) {
                fecharAplicacao();
                break;
            }

            opStr = opStr.trim();
            if (opStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Opção não pode ser vazia! Tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            switch (opStr) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    alterar();
                    break;
                case "4":
                    remover();
                    break;
                case "5":
                    fecharAplicacao();
                    rodando = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Selecione um número de 1 a 5.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cadastrar() {
        String nome = solicitarTexto("Digite o NOME do eletrodoméstico:");
        if (nome == null) return; // Cancelou

        String marca = solicitarTexto("Digite a MARCA:");
        if (marca == null) return; // Cancelou

        String voltagem = solicitarTexto("Digite a VOLTAGEM (ex: 110V, 220V, Bivolt):");
        if (voltagem == null) return; // Cancelou

        Double preco = solicitarPreco("Digite o PREÇO (Exemplo: 1599.90):", null);
        if (preco == null) return; // Cancelou

        boolean sucesso = controle.cadastrarEletrodomestico(nome, marca, voltagem, preco);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Eletrodoméstico cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao gravar registro no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listar() {
        List<Eletrodomestico> lista = controle.listarEletrodomesticos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum eletrodoméstico está cadastrado.", "Listagem", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("=== ELETRODOMÉSTICOS CADASTRADOS ===\n\n");
        for (Eletrodomestico e : lista) {
            sb.append(e.toString()).append("\n----------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Listagem", JOptionPane.INFORMATION_MESSAGE);
    }

    private void alterar() {
        Integer id = solicitarId("Digite o ID do eletrodoméstico que deseja ALTERAR:");
        if (id == null) return; // Cancelou

        Eletrodomestico atual = controle.buscarPorId(id);
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado com o ID: " + id, "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Dados Atuais:\n" + atual.toString(), "Informação", JOptionPane.INFORMATION_MESSAGE);

        String novoNome = solicitarTextoComPadrao("Novo NOME:", atual.getNome());
        if (novoNome == null) return;

        String novaMarca = solicitarTextoComPadrao("Nova MARCA:", atual.getMarca());
        if (novaMarca == null) return;

        String novaVoltagem = solicitarTextoComPadrao("Nova VOLTAGEM:", atual.getVoltagem());
        if (novaVoltagem == null) return;

        Double novoPreco = solicitarPreco("Novo PREÇO (use ponto ex: 1599.90):", String.valueOf(atual.getPreco()));
        if (novoPreco == null) return;

        boolean sucesso = controle.alterarEletrodomestico(id, novoNome, novaMarca, novaVoltagem, novoPreco);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao alterar registro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remover() {
        Integer id = solicitarId("Digite o ID do eletrodoméstico que deseja REMOVER:");
        if (id == null) return; // Cancelou

        Eletrodomestico e = controle.buscarPorId(id);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado com o ID: " + id, "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente excluir este produto?\n\n" + e.toString(),
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean sucesso = controle.removerEletrodomestico(id);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover produto do banco.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada. O produto foi mantido.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // --- MÉTODOS AUXILIARES DE VALIDAÇÃO ---

    private String solicitarTexto(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensagem);
            if (input == null) return null; // Usuário cancelou
            input = input.trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo obrigatório! Não pode ficar em branco.", "Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                return input;
            }
        }
    }

    private String solicitarTextoComPadrao(String mensagem, String valorPadrao) {
        while (true) {
            Object input = JOptionPane.showInputDialog(null, mensagem, "Alterar Registro", JOptionPane.QUESTION_MESSAGE, null, null, valorPadrao);
            if (input == null) return null;
            String texto = input.toString().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo não pode ficar em branco!", "Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                return texto;
            }
        }
    }

    private Double solicitarPreco(String mensagem, String valorPadrao) {
        while (true) {
            Object input;
            if (valorPadrao != null) {
                input = JOptionPane.showInputDialog(null, mensagem, "Entrada de Preço", JOptionPane.QUESTION_MESSAGE, null, null, valorPadrao);
            } else {
                input = JOptionPane.showInputDialog(null, mensagem);
            }

            if (input == null) return null; // Cancelou

            String val = input.toString().trim();
            if (val.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preço é obrigatório!", "Validação", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            try {
                double preco = Double.parseDouble(val);
                if (preco <= 0) {
                    JOptionPane.showMessageDialog(null, "O preço deve ser um valor maior que zero!", "Validação", JOptionPane.WARNING_MESSAGE);
                } else {
                    return preco;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Preço inválido! Formato aceito: apenas números e ponto (ex: 1599.90).", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Integer solicitarId(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensagem);
            if (input == null) return null; // Cancelou
            input = input.trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID é obrigatório!", "Validação", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            try {
                int id = Integer.parseInt(input);
                if (id <= 0) {
                    JOptionPane.showMessageDialog(null, "ID deve ser um número inteiro positivo!", "Validação", JOptionPane.WARNING_MESSAGE);
                } else {
                    return id;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido! Digite apenas números inteiros.", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void fecharAplicacao() {
        JOptionPane.showMessageDialog(null, "Encerrando aplicação. Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
    }
}