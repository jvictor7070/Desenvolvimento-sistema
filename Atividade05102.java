
import java.io.FileWriter;

public class Atividade05102 {
    public static void main(String[] args) {
        
        try {
            FileWriter escritor = new FileWriter("exemplo.txt",true);
            escritor.write("primeira linha\n");
            escritor.write("segunda linha\n");

            escritor.close();
            
        } catch (Exception e) {
        }
    }
    
}
