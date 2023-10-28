package homework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseIntegerList(scanner.nextLine());
        int[] bombInfo = parseIntegerArray(scanner.nextLine());

        detonate(numbers, bombInfo[0], bombInfo[1]);

        int sum = sumList(numbers);
        System.out.println(sum);
    }

    private static List<Integer> parseIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).forEach(numbers::add);
        return numbers;
    }

    private static int[] parseIntegerArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static void detonate(List<Integer> numbers, int bombNumber, int bombPower) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                int leftBound = Math.max(0, i - bombPower);
                int rightBound = Math.min(numbers.size() - 1, i + bombPower);

                for (int j = rightBound; j >= leftBound; j--) { // Reverse loop to avoid index issues when removing.
                    numbers.remove(j);
                }

                i = leftBound - 1; // Reset the loop index to account for removed elements
            }
        }
    }


    private static int sumList(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
