public class CalcApp {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println(calc.somar(10,5));
        System.out.println(calc.somar(3,5,8));
        System.out.println(calc.somar(10.5,6.8));
    }
    
}
