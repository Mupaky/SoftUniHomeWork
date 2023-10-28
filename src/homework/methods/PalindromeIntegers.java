package homework.methods;

import java.util.Scanner;

public class PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            // Stop reading numbers when "END" is entered
            if (input.equals("END")) {
                break;
            }

            boolean isNumPalindrome = isPalindrome(input);
            System.out.println(isNumPalindrome);
        }
    }

    public static boolean isPalindrome(String number) {
        int start = 0;
        int end = number.length() - 1;

        // Compare the characters of the number from start and end till the middle
        while (start < end) {
            if (number.charAt(start) != number.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
