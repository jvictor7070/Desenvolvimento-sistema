import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        // Define o ponto (.) como separador decimal padrão para evitar erros
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== CALCULADORA DE IMC ===");

        // Entrada de dados
        System.out.print("Digite o seu peso em kg (ex: 70.5): ");
        double peso = sc.nextDouble();

        System.out.print("Digite a sua altura em metros (ex: 1.75): ");
        double altura = sc.nextDouble();

        // Cálculo do IMC: Peso / Altura²
        double imc = peso / (altura * altura);

        // Exibição do resultado formatado com 2 casas decimais
        System.out.printf("Seu IMC é: "+imc);


        scanner.close();
    }
}