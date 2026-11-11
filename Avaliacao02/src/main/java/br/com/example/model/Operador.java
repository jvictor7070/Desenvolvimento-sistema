package br.com.example.model;

public class Operador extends Funcionario {
    private String funcao;

    public Operador (int matricula, String nome, int idade, String funcao) {
        super (matricula, nome, idade);
        this.funcao = funcao;
    }
    
        public String getFuncao() {
            return funcao;
        }
    
        public void setFuncao(String funcao) {
            this.funcao=funcao;
        }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Função" + funcao);
    }
}