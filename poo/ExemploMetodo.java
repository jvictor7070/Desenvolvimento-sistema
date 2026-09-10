package poo;
public class ExemploMetodo {
    // sem parametros e sem retorno
    public static void mensagem() {
        System.out.println("Seja bem-vindo");

        
    }
    // com parametros sem retorno
    public static void mostrarNome(String nome) {
        System.out.println("Nome: "+nome);
        
    }
    // sem parametros e com retorno
    public static int obterNumero() {
        return 10;
    }

    // com parametro e com retorno
    public static int somar(int n1,int n2) {
        return n1+n2;
        
    }

    public static void main(String[] args) {
        mensagem();
        mostrarNome("Victor");
        int numero=obterNumero();
        System.out.println("Número: "+numero);
        int resultado=somar(10, 5);
        System.out.println("Soma: "+resultado);
    }
    
}
