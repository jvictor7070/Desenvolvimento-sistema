import java.io.File;
import java.io.IOException;
public class Atividade0510 {
    public static void main(String[] args) {

        try {
            File arquivo = new File("exemplo.txt");
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso "
                + arquivo.getName());
            } else {
                System.out.println("Arquivo já existe");
            }
        } catch(IOException e) {
            System.out.println("ocorreu um erro");
            e.printStackTrace();
        }

    }
}