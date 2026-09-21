public class CursoOnline extends Curso {

    private String enderecoPlataforma;
    private String codigoAcesso;

    public CursoOnline(
            int codigo,
            String nome,
            int cargaHoraria,
            double valor,
            String enderecoPlataforma,
            String codigoAcesso) {

        super(codigo, nome, cargaHoraria, valor);

        this.enderecoPlataforma = enderecoPlataforma;
        this.codigoAcesso = codigoAcesso;
    }

    
    public String getEnderecoPlataforma() {
        return enderecoPlataforma;
    }

    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    
    public void setEnderecoPlataforma(String enderecoPlataforma) {
        this.enderecoPlataforma = enderecoPlataforma;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    @Override
    public double realizarMatricula() {
        return getValor();
    }

    @Override
    public double realizarMatricula(double desconto) {
        return getValor() - desconto;
    }

    @Override
    public void mostrarDados() {

        super.mostrarDados();

        System.out.println("Tipo: Curso Online");
        System.out.println(
                "Endereço da plataforma: "
                        + enderecoPlataforma
        );
        System.out.println(
                "Código de acesso: "
                        + codigoAcesso
        );
    }
}
