public class FuncionarioFreelancer extends Funcionario {

    private double horasTrabalhadas;
    private double valorHora;

    public FuncionarioFreelancer(
            String nome,
            String cpf,
            double salario,
            double horasTrabalhadas,
            double valorHora) {

        super(nome, cpf, salario);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return (horasTrabalhadas * valorHora) + bonus;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.printf("Valor por hora: R$ %.2f%n", valorHora);
    }
}

