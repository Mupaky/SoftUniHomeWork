package homework.basics;

import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStrings = scanner.nextLine().split(" ");
        int[] numbers = new int[inputStrings.length];

        for (int i = 0; i < inputStrings.length; i++) {
            numbers[i] = Integer.parseInt(inputStrings[i]);
        }

        int bestStart = 0;
        int bestLength = 1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentLength++;

                if (currentLength > bestLength) {
                    bestLength = currentLength;
                    bestStart = currentStart;
                }
            } else {
                currentLength = 1;
                currentStart = i;
            }
        }

        for (int i = 0; i < bestLength; i++) {
            System.out.print(numbers[bestStart + i] + " ");
        }
    }
}
