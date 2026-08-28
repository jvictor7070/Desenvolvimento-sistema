import java.util.Scanner; // Importa a ferramenta de leitura do teclado

public class ExemploBase {
    public static void main(String[] args) {
        // Criamos o leitor para capturar a digitação
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota do aluno (0.0 a 10.0): ");
        double nota = scanner.nextDouble();

        // O fluxo do programa toma caminhos diferentes conforme a nota
        if (nota >= 7.0) {
            System.out.println("Status: Aprovado!");
        } else if (nota >= 5.0) {
            System.out.println("Status: Em Recuperação.");
        } else {
            System.out.println("Status: Reprovado.");
        }

        scanner.close(); // Fecha o leitor para liberar memória
    }
}