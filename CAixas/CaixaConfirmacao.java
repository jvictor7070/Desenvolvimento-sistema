package CAixas;

import javax.swing.JOptionPane;

public class CaixaConfirmacao {

    public static void main(String[] args) {
        
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?","Confirmação",JOptionPane.YES_NO_OPTION);

        if (resposta==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Você escolheu sim","Resultado",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Você escolheu não!","Resultado",JOptionPane.WARNING_MESSAGE);
        
        }
    }
    
}

