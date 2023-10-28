package homework.methods;

import java.util.Scanner;

public class TopNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    // Method to check if a number is a top number
    public static boolean isTopNumber(int number) {
        return isSumOfDigitsDivisibleByEight(number) && containsOddDigit(number);
    }

    // Method to check if sum of digits of a number is divisible by 8
    public static boolean isSumOfDigitsDivisibleByEight(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum % 8 == 0;
    }

    // Method to check if a number contains at least one odd digit
    public static boolean containsOddDigit(int number) {
        while (number > 0) {
            if ((number % 10) % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
