package br.com.example.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.example.model.Funcionario;
import br.com.example.model.Gerente;
import br.com.example.model.Operador;

public class FuncionarioView {

    public int menu() {
        String menu = "SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS\n\n"
                + "1 - Cadastrar funcionário\n"
                + "2 - Listar funcionários\n"
                + "3 - Pesquisar funcionário\n"
                + "4 - Alterar funcionário\n"
                + "5 - Excluir funcionário\n"
                + "0 - Sair\n\n"
                + "Escolha uma opção:";

        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog(menu));
        } catch (Exception e) {
            return -1;
        }
    }

    public int solicitarTipo() {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "TIPO DE FUNCIONÁRIO\n\n"
                            + "1 - Gerente\n"
                            + "2 - Operador"));
        } catch (Exception e) {
            return -1;
        }
    }

    public int solicitarMatricula() {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog("Digite a matrícula:"));
        } catch (Exception e) {
            return -1;
        }
    }

    public String solicitarNome() {
        return JOptionPane.showInputDialog("Digite o nome:");
    }

    public int solicitarIdade() {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog("Digite a idade:"));
        } catch (Exception e) {
            return -1;
        }
    }

    public String solicitarDepartamento() {
        return JOptionPane.showInputDialog("Digite o departamento:");
    }

    public String solicitarFuncao() {
        return JOptionPane.showInputDialog("Digite a função:");
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public boolean confirmarExclusao() {
        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente excluir este funcionário?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        return resposta == JOptionPane.YES_OPTION;
    }

    public void exibirFuncionario(Funcionario funcionario) {
        String dados = "Matrícula: " + funcionario.getMatricula()
                + "\nNome: " + funcionario.getNome()
                + "\nIdade: " + funcionario.getIdade();

        if (funcionario instanceof Gerente) {
            Gerente gerente = (Gerente) funcionario;
            dados += "\nTipo: Gerente"
                    + "\nDepartamento: " + gerente.getDepartamento();

        } else if (funcionario instanceof Operador) {
            Operador operador = (Operador) funcionario;
            dados += "\nTipo: Operador"
                    + "\nFunção: " + operador.getFuncao();
        }

        JOptionPane.showMessageDialog(null, dados);
    }

    public void exibirFuncionarios(List<Funcionario> funcionarios) {
        String dados = "LISTA DE FUNCIONÁRIOS\n\n";

        for (Funcionario funcionario : funcionarios) {
            dados += "Matrícula: " + funcionario.getMatricula()
                    + "\nNome: " + funcionario.getNome()
                    + "\nIdade: " + funcionario.getIdade();

            if (funcionario instanceof Gerente) {
                Gerente gerente = (Gerente) funcionario;
                dados += "\nTipo: Gerente"
                        + "\nDepartamento: " + gerente.getDepartamento();

            } else if (funcionario instanceof Operador) {
                Operador operador = (Operador) funcionario;
                dados += "\nTipo: Operador"
                        + "\nFunção: " + operador.getFuncao();
            }

            dados += "\n-------------------------\n";
        }

        JOptionPane.showMessageDialog(null, dados);
    }}