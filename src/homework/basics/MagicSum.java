package homework.basics;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parse input array
        String[] inputStrings = scanner.nextLine().split(" ");
        int[] numbers = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            numbers[i] = Integer.parseInt(inputStrings[i]);
        }

        // Get the desired sum
        int desiredSum = Integer.parseInt(scanner.nextLine());

        // Traverse the array
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // If the sum of numbers[i] and numbers[j] equals the desired sum, print them
                if (numbers[i] + numbers[j] == desiredSum) {
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }
    }
}
