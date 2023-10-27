package homework;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStrings = scanner.nextLine().split(" ");
        int[] numbers = new int[inputStrings.length];

        for (int i = 0; i < inputStrings.length; i++) {
            numbers[i] = Integer.parseInt(inputStrings[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0, rightSum = 0;

            // Compute sum of elements on the left of i
            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            // Compute sum of elements on the right of i
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            // Check if leftSum is equal to rightSum
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }
}