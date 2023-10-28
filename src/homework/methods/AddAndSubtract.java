package homework.methods;

import java.util.Scanner;

public class AddAndSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        int sumResult = sum(firstNum, secondNum);
        int finalResult = subtract(sumResult, thirdNum);

        System.out.println(finalResult);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int sum, int num) {
        return sum - num;
    }
}
