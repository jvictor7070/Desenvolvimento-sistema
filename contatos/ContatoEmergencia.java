package contatos;
public class ContatoEmergencia extends Contato {
    private String grauPrioridade;

    public ContatoEmergencia(String nome, String numero, String grauPrioridade) {
        super(nome, numero);
        this.grauPrioridade = grauPrioridade;
    }

    public String getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(String grauPrioridade) {
        this.grauPrioridade = grauPrioridade;
    }

    @Override
    public String exibirDados() {
        return super.exibirDados() + 
               "\nTipo: Emergência" + 
               "\nPrioridade: " + grauPrioridade;
    }
}