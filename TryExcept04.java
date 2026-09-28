import java.util.Scanner;

public class TryExcept04 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite um nome:");
            String nome = sc.nextLine();
            if(nome.trim().isEmpty()) {
                throw new Exception("Nome não pode ser vazio");
                }
            System.out.println("Nome: " + nome);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("fim do programa");
            }

        }
    }
