package br.com.example.model;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente (int matricula, String nome, int idade, String departamento) {
    super (matricula, nome, idade);
    this.departamento = departamento;
    }
    
        public String getDepartamento() {
            return departamento;
        }
    
        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

    @Override
    public void exibirInfo() {
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Tipo: Gerente");
        System.out.println("Departamento: " + departamento);
    }


}