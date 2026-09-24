public class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public double calcularPagamento() {
        return getSalario();
    }

    @Override
    public double calcularPagamento(double bonus) {
        return getSalario() + bonus;
    }
}
