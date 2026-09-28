import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.00;
        
        System.out.println("Saldo disponível: R$ " + saldo);

        try {
            System.out.print("Digite o valor que deseja sacar: ");
            double valorSaque = sc.nextDouble();

            // Validação de valores <= 0
            if (valorSaque <= 0) {
                throw new IllegalArgumentException("O valor do saque deve ser positivo e maior que zero.");
            } 
            
            // Validação de saldo
            if (valorSaque > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }

            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + saldo);

        } catch (InputMismatchException e) {
            System.out.println("Erro Crítico: entrada inválida! Por favor, use apenas números e vírgula.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Erro matemático: Divisão por zero não permitida.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            // Ajustado para atender ao requisito exato do slide
            System.out.println("Operação encerrada");
            sc.close();
        }
    }
}