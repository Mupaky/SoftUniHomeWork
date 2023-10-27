package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class TopIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split(" ");
        int[] numbers = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        ArrayList<Integer> topIntegers = new ArrayList<>();
        int maxFromRight = Integer.MIN_VALUE;

        // Traverse the array from right to left
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] >= maxFromRight) {
                maxFromRight = numbers[i];
                topIntegers.add(maxFromRight);
            }
        }

        // Print the top integers in reverse order
        for (int i = topIntegers.size() - 1; i >= 0; i--) {
            System.out.print(topIntegers.get(i) + " ");
        }
    }
}
