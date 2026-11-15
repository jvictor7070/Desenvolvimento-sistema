package br.com.example.model;

public class FuncionarioPadrao extends Funcionario {
    public FuncionarioPadrao(int matricula, String nome, int idade) {
        super(matricula, nome, idade);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Funcionário Padrão: " + getNome());
    }
}