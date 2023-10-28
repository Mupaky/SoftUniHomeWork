package homework.methods;

import java.util.Scanner;
import java.text.DecimalFormat;

public class FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        double result = factorialDivision(firstNumber, secondNumber);

        DecimalFormat df = new DecimalFormat("0.00");  // Format to 2 decimal places
        System.out.println(df.format(result));
    }

    public static double factorial(int number) {
        double result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    public static double factorialDivision(int firstNumber, int secondNumber) {
        double firstFactorial = factorial(firstNumber);
        double secondFactorial = factorial(secondNumber);

        return firstFactorial / secondFactorial;
    }
}
