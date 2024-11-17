import java.util.Scanner;

public class calc {
    public static void main(String[] args)  throws Exception  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }
    public static String parse(String expression) throws Exception {

        String[] operands = expression.split("[+\\-*/]");
        int num1 = Integer.parseInt(operands[0]);
        int num2 = Integer.parseInt(operands[1]);
        if (operands.length !=2) throw new Exception ("Не более двух операндов");
        if (num1 < 1 || num2 < 1 || num1>10 || num2>10){
            throw new Exception ("Числа должны быть от 1 до 10");
        }
        String oper;
        oper = symbol(expression);
        int numbers = calc(num1, num2, oper);
        String result;
        result = String.valueOf(numbers);
        return result;

    }
    static int calc(int a,int b, String oper){
        if(oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b ;
    }
    static String symbol(String expression) throws Exception {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else throw new Exception("Недопустимая арифметическая операция");
    }

}
