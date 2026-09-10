public class ClientePF extends Cliente{
    private String cpf;

    public ClientePF(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
    }

    public String getcpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override 
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Cpf" + cpf);
    }
}
