package homework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseIntegerList(scanner.nextLine());

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String[] commandParts = command.split("\\s+");

            switch (commandParts[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(commandParts[1]));
                    break;
                case "Insert":
                    insert(numbers, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    break;
                case "Remove":
                    remove(numbers, Integer.parseInt(commandParts[1]));
                    break;
                case "Shift":
                    if (commandParts[1].equals("left")) {
                        shiftLeft(numbers, Integer.parseInt(commandParts[2]));
                    } else {
                        shiftRight(numbers, Integer.parseInt(commandParts[2]));
                    }
                    break;
            }
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> parseIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).forEach(numbers::add);
        return numbers;
    }

    private static void insert(List<Integer> numbers, int number, int index) {
        if (index >= 0 && index < numbers.size()) {
            numbers.add(index, number);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void remove(List<Integer> numbers, int index) {
        if (index >= 0 && index < numbers.size()) {
            numbers.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int firstElement = numbers.remove(0);
            numbers.add(firstElement);
        }
    }

    private static void shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int lastElement = numbers.remove(numbers.size() - 1);
            numbers.add(0, lastElement);
        }
    }
}
