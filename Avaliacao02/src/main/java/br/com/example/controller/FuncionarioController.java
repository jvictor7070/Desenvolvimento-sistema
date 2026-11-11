package br.com.example.controller;

import java.util.List;

import br.com.example.dao.FuncionarioDao;
import br.com.example.model.Funcionario;
import br.com.example.model.Gerente;
import br.com.example.model.Operador;
import br.com.example.view.FuncionarioView;

public class FuncionarioController {

    private FuncionarioDao dao;
    private FuncionarioView view;

    public FuncionarioController() {
        dao = new FuncionarioDao();
        view = new FuncionarioView();
    }

    public void iniciar() {
        int opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    pesquisar();
                    break;

                case 4:
                    alterar();
                    break;

                case 5:
                    remover();
                    break;

                case 0:
                    view.mostrarMensagem("Sistema encerrado!");
                    break;

                default:
                    view.mostrarMensagem("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrar() {
        int tipo = view.solicitarTipo();

        if (tipo != 1 && tipo != 2) {
            view.mostrarMensagem("Tipo de funcionário inválido!");
            return;
        }

        int matricula = view.solicitarMatricula();
        String nome = view.solicitarNome();
        int idade = view.solicitarIdade();

        if (nome == null || nome.trim().isEmpty() || idade <= 0) {
            view.mostrarMensagem("Preencha os dados corretamente!");
            return;
        }

        Funcionario funcionario;

        if (tipo == 1) {
            String departamento = view.solicitarDepartamento();

            if (departamento == null || departamento.trim().isEmpty()) {
                view.mostrarMensagem("Departamento obrigatório!");
                return;
            }

            funcionario = new Gerente(matricula, nome, idade, departamento);

        } else {
            String funcao = view.solicitarFuncao();

            if (funcao == null || funcao.trim().isEmpty()) {
                view.mostrarMensagem("Função obrigatória!");
                return;
            }

            funcionario = new Operador(matricula, nome, idade, funcao);
        }

        if (dao.cadastrar(funcionario)) {
            view.mostrarMensagem("Funcionário cadastrado com sucesso!");
        } else {
            view.mostrarMensagem("Erro ao cadastrar funcionário. Verifique a matrícula.");
        }
    }

    private void listar() {
        List<Funcionario> funcionarios = dao.listar();

        if (funcionarios.isEmpty()) {
            view.mostrarMensagem("Nenhum funcionário cadastrado.");
        } else {
            view.exibirFuncionarios(funcionarios);
        }
    }

    private void pesquisar() {
        int matricula = view.solicitarMatricula();

        Funcionario funcionario = dao.buscar(matricula);

        if (funcionario != null) {
            view.exibirFuncionario(funcionario);
        } else {
            view.mostrarMensagem("Funcionário não encontrado!");
        }
    }

    private void alterar() {
        int matricula = view.solicitarMatricula();

        Funcionario funcionario = dao.buscar(matricula);

        if (funcionario == null) {
            view.mostrarMensagem("Funcionário não encontrado!");
            return;
        }

        String nome = view.solicitarNome();
        int idade = view.solicitarIdade();

        if (nome == null || nome.trim().isEmpty() || idade <= 0) {
            view.mostrarMensagem("Dados inválidos!");
            return;
        }

        funcionario.setNome(nome);
        funcionario.setIdade(idade);

        if (funcionario instanceof Gerente) {
            String departamento = view.solicitarDepartamento();

            if (departamento == null || departamento.trim().isEmpty()) {
                view.mostrarMensagem("Departamento obrigatório!");
                return;
            }

            ((Gerente) funcionario).setDepartamento(departamento);

        } else if (funcionario instanceof Operador) {
            String funcao = view.solicitarFuncao();

            if (funcao == null || funcao.trim().isEmpty()) {
                view.mostrarMensagem("Função obrigatória!");
                return;
            }

            ((Operador) funcionario).setFuncao(funcao);
        }

        if (dao.alterar(funcionario)) {
            view.mostrarMensagem("Funcionário alterado com sucesso!");
        } else {
            view.mostrarMensagem("Erro ao alterar funcionário!");
        }
    }

    private void remover() {
        int matricula = view.solicitarMatricula();

        Funcionario funcionario = dao.buscar(matricula);

        if (funcionario == null) {
            view.mostrarMensagem("Funcionário não encontrado!");
            return;
        }

        boolean confirmar = view.confirmarExclusao();

        if (confirmar) {
            if (dao.remover(matricula)) {
                view.mostrarMensagem("Funcionário excluído com sucesso!");
            } else {
                view.mostrarMensagem("Erro ao remover funcionário!");
            }
        }
    }
}
