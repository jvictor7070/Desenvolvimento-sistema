import java.util.ArrayList;
import javax.swing.JOptionPane;
public class CaixaMenu {
    public static void main(String[] args) {
        
        ArrayList<String> produtos = new ArrayList<>();

        boolean executando=true;

        while(executando){
            String opcao = JOptionPane.showInputDialog(
            null,
            "Escolha uma opcao:\n"+
            "1-Cadastrar produto\n"+
            "2-Listar produto\n"+
            "3-sair","Menu Principal",
            JOptionPane.QUESTION_MESSAGE
            );
            if (opcao==null){
                JOptionPane.showMessageDialog(null, "operação cancelada");
                break;
            }

            switch(opcao){
                case"1":
                String produto = JOptionPane.showInputDialog(null,"digite o nome do produto","Cadastro produto",JOptionPane.QUESTION_MESSAGE
                );
                if (produto==null || produto.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Produto não cadastrado !");
                }else{
                    produtos.add(produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                }
                break;
                case "2":
                if (produtos.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                }else{
                    String lista = "Produtos cadastrados\n\n";

                    for(int i=0;i<produtos.size();i++){
                        lista+=(i+1)+"-"+produtos.get(i)+"\n";
                    }
                    JOptionPane.showMessageDialog(null, lista,"Lista de produtos",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                }
                break;
                case "3":
                    JOptionPane.showMessageDialog(null, "saindo...");
                    executando=false;
                    break;
            default:
            JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;
            }
        }
    }
    
}
