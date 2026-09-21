public abstract class Curso implements Matricula {

    private int codigo;
    private String nome;
    private int cargaHoraria;
    private double valor;

    public Curso(
            int codigo,
            String nome,
            int cargaHoraria,
            double valor) {

        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.valor = valor;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getValor() {
        return valor;
    }

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void mostrarDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println(
                "Carga horária: " + cargaHoraria + " horas"
        );
        System.out.printf(
                "Valor: R$ %.2f%n",
                valor
        );
    }
}
