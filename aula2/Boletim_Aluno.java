public class Boletim_Aluno {
    public static void main(String[] args) {
        String nome = "João Victor";
        double nota1 = 8.50;
        double nota2 = 7.75;
        double media = (nota1+nota2)/2;

        System.out.printf(
            " Aluno:%s%n nota1:%.2f%n nota2:%.2f%n media:%.2f%n"
            ,nome,
            nota1,
            nota2,
            media);
    }
    
}
