package caixaveiculo;
public class CaixaCarro extends CaixaVeiculo {
    public CaixaCarro(String marca,String modelo, int ano){
        super(marca, modelo, ano);
    }

    @Override 
    public String exibirDetalhes(){
        return "-----DETALHES DO VEÍCULO-----\n"+ super.exibirDetalhes();
    }
    
}
